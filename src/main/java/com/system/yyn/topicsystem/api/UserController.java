package com.system.yyn.topicsystem.api;

import com.system.yyn.topicsystem.entity.po.User;
import com.system.yyn.topicsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : lyj
 * @description:
 * @date :2020/3/22  7:31
 */
@Controller
@RequestMapping("/userInfo")
public class UserController {


    @Resource
    private UserService userService;

    /**
     * 注册用户
     * @return
     */
    @RequestMapping("/reg")
    public String reg(HttpServletRequest request){
        User user = new User();
        user.setUserName(request.getParameter("user"));
        user.setPassWord(request.getParameter("psw"));
        user.setCellphone(request.getParameter("phone"));
        user.setUserType(request.getParameter("userType"));
        int result = userService.regist(user);
        if (result == 1) {
            request.setAttribute("success", "注册成功");
            request.getSession().setAttribute("username",user.getUserName());
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
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        User user = new User();
        user.setUserName(request.getParameter("user"));
        user.setPassWord(request.getParameter("psw"));
        user.setUserType("0");
        User u = userService.findUser(user);
        if (u == null) {
            request.setAttribute("error","用户名或密码错误");
            return "login";
        } else {
            request.getSession().setAttribute("username",user.getUserName());
            return "index";
        }
    }




}
