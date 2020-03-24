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
            if (user.getUserType().equals("0")) {
                return "redirect:/";
            } else {
                return "redirect:/adminHome";
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
            //学生
            if (userType.equals("0")) {
                request.getSession().setAttribute("username", user1.getUserName());
                request.getSession().setAttribute("cellphone", user1.getCellphone());
                return "index";
            }
            //教师
            else if (userType.equals("1")) {
                request.getSession().setAttribute("username", user1.getUserName());
                request.getSession().setAttribute("cellphone", user1.getCellphone());
                return "admin/admin";
            }
            //系主任
            else if (userType.equals("3")) {

            }
            //管理员
            else if (userType.equals("4")) {

            }
            request.setAttribute("error", "用户类型错误");
            return "login";
        }
    }

    @RequestMapping("/userInfo")
    public String userInfo(HttpServletRequest request) {

        String cellphone = (String) request.getSession().getAttribute("cellphone");
        User user = new User();
        user.setCellphone(cellphone);
        User userInfo = userService.getUserInfo(user);
        if (null != userInfo) {
            request.setAttribute("user", userInfo);
            return "updateUserInfo";
        }
        request.setAttribute("error", "未查到用户信息");
        return "login";
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String newPassword = request.getParameter("newPassword");
        String cellphone = request.getParameter("cellphone");
        User user = new User();
        user.setCellphone(cellphone);
        user.setUserName(userName);
        if (StringUtils.isNotBlank(newPassword)) {
            user.setPassWord(newPassword);
        }
        int result = userService.updateUser(user);
        if (result == 1) {
            request.setAttribute("success", "用户信息修改成功");
        } else {
            request.setAttribute("error", "用户信息修改失败");
        }
        User userInfo = userService.getUserInfo(user);
        request.setAttribute("user", userInfo);
        return "redirect:/userInfo/userInfo";
    }


}
