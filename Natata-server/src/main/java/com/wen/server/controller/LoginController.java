package com.wen.server.controller;

import com.wen.server.entity.Admin;
import com.wen.server.entity.AdminLoginParam;
import com.wen.server.entity.RespEntity;
import com.wen.server.service.impl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录接口
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {
    @Autowired
    private AdminServiceImpl adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespEntity login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), request);
    }

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (null == principal) {
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUsername(username);
        admin.setPassword(null);
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespEntity logout() {
        return RespEntity.success("注销成功!");
    }


}
