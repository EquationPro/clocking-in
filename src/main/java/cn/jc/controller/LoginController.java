package cn.jc.controller;

import cn.jc.entity.Employees;
import cn.jc.entity.Login;
import cn.jc.entity.Station;
import cn.jc.service.EmployeesService;
import cn.jc.service.LoginService;
import cn.jc.service.StationService;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService service;
    @Autowired
    private EmployeesService employeesService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultMap login(String username, String password, HttpSession session) {
        Login login = service.login(username, password);
        if (login != null) {
            session.setAttribute("empCode", username);
            Employees employees = employeesService.loadByEmpCodeEmployees(username);
            String empName = employees.getEmpName();
            session.setAttribute("empName", empName);
            Date date = new Date();
            SimpleDateFormat all = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            String loginDate = all.format(date);
            session.setAttribute("loginDate",loginDate);
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }
}
