package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.entity.po.Bulletin;
import com.system.yyn.topicsystem.entity.po.User;
import com.system.yyn.topicsystem.service.BulletinService;
import com.system.yyn.topicsystem.service.UserService;
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
    public String getUserList(HttpServletRequest request) {

        String type = request.getParameter("type");
        User user = new User();
        user.setUserType(type);
        List<User> userList = userService.getUserList(user);
        request.setAttribute("userList", userList);
        return "";//用户列表
    }

    /**
     * 公告列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/sys/queryBulletins")
    public String toBulletinList(HttpServletRequest request) {
        List<Bulletin> list = bulletinService.getList();
        request.setAttribute("bulletins", list);
        return "";//公告列表页面
    }

    /**
     * 发公告
     *
     * @return
     */
    @RequestMapping("/sys/toSend")
    public String toSendBulletin() {
        return "";//发公告页面
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
        return "";//公告列表页面
    }

    @RequestMapping("/sys/toSend")
    public String toUpdateBul(HttpServletRequest request) {
        String id = request.getParameter("id");
        Bulletin bulletin = new Bulletin();
        bulletin.setId(Long.parseLong(id));
        Bulletin select = bulletinService.select(bulletin);
        request.setAttribute("bulletin", select);
        return "";//修改页面
    }

    @RequestMapping("/sys/updateBul")
    public String updateBul(HttpServletRequest request) {
        String id = request.getParameter("id");
        Bulletin bulletin = new Bulletin();
        bulletin.setId(Long.parseLong(id));
        int update = bulletinService.update(bulletin);
        if (update == 1) {
            request.setAttribute("success", "修改成功");
        } else {
            request.setAttribute("error", "修改失败");
        }
        return "";//公告列表
    }

    @RequestMapping("/sys/deleteBul")
    public String delBul(HttpServletRequest request) {
        String id = request.getParameter("id");
        Bulletin bulletin = new Bulletin();
        bulletin.setId(Long.parseLong(id));
        int delete = bulletinService.delete(bulletin);
        if (delete == 1) {
            request.setAttribute("success", "发布成功");
        } else {
            request.setAttribute("error", "发布失败");
        }
        return "";//公告列表
    }
}
