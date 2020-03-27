package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.entity.po.Bulletin;
import com.system.yyn.topicsystem.entity.po.User;
import com.system.yyn.topicsystem.service.BulletinService;
import com.system.yyn.topicsystem.service.UserService;
import com.system.yyn.topicsystem.utils.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName : SystemController
 * @Description : 系统管理员
 */
@Controller
public class SystemController {

    @Resource
    private UserService userService;
    @Resource
    private BulletinService bulletinService;

    /**
     * 获取用户列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/sys/getUserList")
    public String getUserList(User user,HttpServletRequest request) {
        List<User> userList = userService.getUserList(user);
        request.setAttribute("userList", userList);
         return "system/sysUserList";//用户列表
    }

    /**
     * 公告列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/sys/queryBulletins")
    public String toBulletinList(HttpServletRequest request) {
        String success = request.getParameter("success");
        String error = request.getParameter("error");
        if (StringUtils.isNotBlank(success) && success.equals(Constant.UPDATE_SUCCESS)) {
            request.setAttribute("success", "修改成功");
        }
        if (StringUtils.isNotBlank(error) && error.equals(Constant.UPDATE_ERROR)) {
            request.setAttribute("error", "修改失败");
        }

        List<Bulletin> list = bulletinService.getList();
        request.setAttribute("bulletins", list);

        return "system/sysIndex";//公告列表页面
    }

    /**
     * 发公告
     *
     * @return
     */
    @RequestMapping("/sys/toSend")
    public String toSendBulletin() {
        return "system/sysSendBul";//发公告页面
    }

    /**
     * 发公告
     *
     * @param request
     * @return
     */
    @RequestMapping("/sys/sendBulletin")
    public String sendBulletin(Bulletin bulletin, HttpServletRequest request) {
        int send = bulletinService.send(bulletin);
        if (send == 1) {
            request.setAttribute("success", "发布成功");
        } else {
            request.setAttribute("error", "发布失败");
        }
        return "redirect:/sys/queryBulletins";//公告列表页面
    }

    @RequestMapping("/sys/toUpdate")
    public String toUpdateBul(HttpServletRequest request) {
        String id = request.getParameter("id");
        Bulletin bulletin = new Bulletin();
        bulletin.setId(Long.parseLong(id));
        Bulletin select = bulletinService.select(bulletin);
        request.setAttribute("bulletin", select);
        return "system/sysUpdateBul";//修改页面
    }

    @RequestMapping("/sys/updateBul")
    public String updateBul(Bulletin bulletin, HttpServletRequest request) {
        int update = bulletinService.update(bulletin);
        if (update == 1) {
            return "redirect:/sys/queryBulletins";//公告列表
        } else {
            return "redirect:/sys/queryBulletins";//公告列表
        }
    }

    @RequestMapping("/sys/deleteBul")
    public String delBul(Bulletin bulletin,HttpServletRequest request) {
        int delete = bulletinService.delete(bulletin);
        if (delete == 1) {
            request.setAttribute("success", "删除成功");
        } else {
            request.setAttribute("error", "删除失败");
        }
        return "redirect:/sys/queryBulletins";//公告列表
    }

    @RequestMapping("/sys/deleteUser")
    public String delUser(HttpServletRequest request){
        String cellphone = request.getParameter("cellphone");
        User user = new User();
        user.setCellphone(cellphone);
        int result = userService.delUser(user);
        return "redirect:/sys/getUserList";
    }

    @RequestMapping("/sys/updateUser")
    public String updateUser(User user,HttpServletRequest request){
        int i = userService.updateUser(user);
        return "redirect:/sys/getUserList";
    }
}
