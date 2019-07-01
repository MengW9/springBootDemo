package com.controller;

import com.pojo.TestNum;
import com.service.NumService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private NumService numService;

    @RequestMapping("/test")
    @ResponseBody
    public int getNum() throws Exception {
        List<TestNum> list = numService.getNum();
        int aa = list.get(0).getNumber();
        return aa;
    }

    @RequestMapping("/yofc")
    @ResponseBody
    public String getYofc() {
        String aa = "this  is  getYofc";
        return aa;
    }

    @RequestMapping("/tologin")
    @ResponseBody
    public String getLogin(Model model) {
        String login = "please sign in";
        System.out.println(login);
        return login;
    }

    /**
     * 登录逻辑处理
     */
    @RequestMapping("/login")
    public String login(String name, String password, Model model) {
        System.out.println("name===      " + name);
        /**
         * 使用shiro编写认证操作
         *
         */
        //1、获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        //3、执行登录方法
        try {
            subject.login(token);
            //登录成功
            //跳转到
            return "redirect:test";
        } catch (UnknownAccountException e) {
            //登录失败:用户名不存在
//            model.addAttribute("msg", "用户名不存在");
            System.out.println("用户名不存在");
            return "redirect:login";
        } catch (IncorrectCredentialsException e) {
            //登录失败:用户名不存在
//            model.addAttribute("msg", "密码错误");
            System.out.println("密码错误");
            return "redirect:login";
        }

    }
}
