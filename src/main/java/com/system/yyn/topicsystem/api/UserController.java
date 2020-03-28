package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.entity.po.User;
import com.system.yyn.topicsystem.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description: 用户信息
 */
@Controller
@RequestMapping("/userInfo")
public class UserController {


    @Resource
    private UserService userService;

    /**
     * 注册用户
     *
     * @return
     */
    @RequestMapping("/reg")
    public String reg(HttpServletRequest request) {
        User user = new User();
        user.setUserName(request.getParameter("user"));
        user.setPassWord(request.getParameter("psw"));
        user.setCellphone(request.getParameter("phone"));
        user.setUserType(request.getParameter("userType"));
        int result = userService.regist(user);
        if (result == 1) {
            request.setAttribute("success", "注册成功");

            request.getSession().setAttribute("username", user.getUserName());
            request.getSession().setAttribute("cellphone", user.getCellphone());
            request.getSession().setAttribute("usertype", user.getUserType());
            String userType = user.getUserType();
            //学生
            if (userType.equals("0")) {
                return "index";
            }
            //教师
            else if (userType.equals("1")) {
                return "redirect:/common/queryBulletins";
            }
            //系主任
            else if (userType.equals("2")) {
                return "redirect:/common/queryBulletins";
            }
            //管理员
            else if (userType.equals("3")) {
                //查询公告
                return "redirect:/sys/queryBulletins";
            } else {
                return "login";
            }
        }
        request.setAttribute("error", "●︿●用户名已存在，请重新注册！");
        return "register";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        User user = new User();
        user.setUserName(request.getParameter("user"));
        user.setPassWord(request.getParameter("psw"));
        user.setUserType(request.getParameter("userType"));
        User user1 = userService.findUser(user);
        if (user1 == null) {
            request.setAttribute("error", "用户名或密码错误");
            return "login";
        } else {
            String userType = user1.getUserType();
            request.getSession().setAttribute("username", user1.getUserName());
            request.getSession().setAttribute("cellphone", user1.getCellphone());
            request.getSession().setAttribute("usertype", user1.getUserType());
            //学生
            if (userType.equals("0")) {
                return "redirect:/common/queryBulletins";
            }
            //教师
            else if (userType.equals("1")) {
                return "redirect:/common/queryBulletins";
            }
            //系主任
            else if (userType.equals("2")) {
                return "redirect:/common/queryBulletins";
            }
            //管理员
            else if (userType.equals("3")) {
                //查询公告
                return "redirect:/sys/queryBulletins";
            }
            request.setAttribute("error", "用户类型错误");
            return "login";
        }
    }

    /**
     * 获取用户信息，跳转修改用户信息页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/userInfo")
    public String userInfo(HttpServletRequest request) {

        //接收修改接口返回的结果
        String success = (String) request.getSession().getAttribute("success");
        String error = (String) request.getSession().getAttribute("error");
        if (StringUtils.isNotBlank(success) && success.equals("1")) {
            request.setAttribute("success", "修改成功,需重新登录");
            request.getSession().removeAttribute("success");
        }
        if (StringUtils.isNotBlank(error) && error.equals("1")) {
            request.setAttribute("error", "修改失败");
            request.getSession().removeAttribute("error");
        }

        //查询用户信息
        String type = request.getParameter("type");
        User user = new User();
        if (StringUtils.isNotBlank(type) && type.equals("1")) {
            String phone = request.getParameter("phone");
            user.setCellphone(phone);
        } else {
            String cellphone = (String) request.getSession().getAttribute("cellphone");
            user.setCellphone(cellphone);
        }
        User userInfo = userService.getUserInfo(user);
        //系统管理员修改用户信息
        if (StringUtils.isNotBlank(type) && type.equals("1")) {
            if (null != userInfo) {
                request.setAttribute("user", userInfo);
                return "system/sysUpdateUserInfo";
            } else {
                request.setAttribute("error", "未查到用户信息");
                return "redirect:/sys/getUserList";
            }
        } else {
            if (null != userInfo) {
                request.setAttribute("user", userInfo);
                return "updateUserInfo";
            } else {
                request.setAttribute("error", "未查到用户信息");
                return "login";
            }
        }

    }

    /**
     * 修改用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(HttpServletRequest request) {

        String userName = request.getParameter("userName");
        String newPassword = request.getParameter("newPassword");
        String cellphone = request.getParameter("cellphone");

        User update = new User();
        update.setCellphone(cellphone);
        update.setUserName(userName);
        if (StringUtils.isNotBlank(newPassword)) {
            update.setPassWord(newPassword);
        }
        int result = userService.updateUser(update);
        if (result == 1) {
            request.getSession().setAttribute("success", "1");
        } else {
            request.getSession().setAttribute("error", "1");
        }
        return "redirect:/userInfo/userInfo";
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        request.getSession().removeAttribute("cellphone");
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("usertype");
        return "login";
    }


}
