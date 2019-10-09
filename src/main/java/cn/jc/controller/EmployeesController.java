package cn.jc.controller;


import cn.jc.entity.Employees;
import cn.jc.entity.Login;
import cn.jc.entity.PageBean;
import cn.jc.service.EmployeesService;
import cn.jc.service.LoginService;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService service;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap listByPage(Integer page, Integer limit,HttpSession session) {
        PageBean<Employees> pageBean = service.listByPage(page, limit);
        //用于获取员工列表,存域显示于部门表的insert和update的下拉控件
        List<Employees> employeesAll = service.listAll();
        List<String> empNames = new ArrayList<>();
        List<String> empCodes = new ArrayList<>();
        for (Employees employees1 : employeesAll) {
            empNames.add(employees1.getEmpName());
            empCodes.add(employees1.getEmpCode());
        }
        session.setAttribute("empNames", empNames);
        session.setAttribute("empCodes", empCodes);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(String empCode, String empName, String empSex, Integer empAge, String empNation, String empIdentity, Integer empSalary, String empPhone, String empContact, String empContactPhone, String empStationId, String empDesc) {
        String empCla = "二卡制";
        Integer rs = service.insertEmployees(new Employees(empCode, empName, empSex, empAge, empNation, empIdentity, empSalary, empPhone, empContact, empContactPhone, empStationId, empCla, empDesc));
        if (rs > 0) {
            Integer rs2 = loginService.insertLogin(new Login(empCode, "123456"));
            if (rs2 > 0) {
                return ResultMap.justOk();
            }
        } else {
            return ResultMap.justFail();
        }
        return null;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(Integer empId) {
        Integer rs = service.deleteEmployees(empId);
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delAll")
    @ResponseBody
    public ResultMap deleteAll(String empIds) {
        String[] split = empIds.split(",");
        for (String empId : split) {
            service.deleteEmployees(Integer.valueOf(empId));
        }
        return ResultMap.justOk();
    }

    @RequestMapping("/loadById")
    public String loadById(Integer empId, HttpSession session) {
        Employees employees = service.loadEmployees(empId);
        session.setAttribute("employees", employees);
        return "/employees_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(String empCode, String empName, String empSex, Integer empAge, String empNation, String empIdentity, Integer empSalary, String empPhone, String empContact, String empContactPhone, String empStationId, String empDesc, HttpSession session) {
        Employees employees = (Employees)session.getAttribute("employees");
        Integer empId = employees.getEmpId();
        String empCla = employees.getEmpCla();
        Integer rs = service.updateEmployees(new Employees(empId,empCode, empName, empSex, empAge, empNation, empIdentity, empSalary, empPhone, empContact, empContactPhone, empStationId, empCla, empDesc));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/searchEmployees")
    @ResponseBody
    public ResultMap search(Integer page, Integer limit,String empNameOrEmpCode) {
        PageBean<Employees> pageBean = service.listByPageSearch(page, limit,empNameOrEmpCode);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

}
