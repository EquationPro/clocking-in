package cn.jc.controller;

import cn.jc.entity.Department;
import cn.jc.entity.PageBean;
import cn.jc.service.DepartmentService;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/department")
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap listByPage(Integer page, Integer limit,HttpSession session) {
        PageBean<Department> pageBean = service.listByPage(page, limit);
        List<Department> departments = service.listAll();
        List<String> depNames=new ArrayList<>();
        for (Department department : departments) {
           depNames.add(department.getDepName());
        }
        session.setAttribute("depNames",depNames);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(String depCode, String depName, String depHead, String depResponsibility, String depSuperiorId) {
        Integer rs = service.insertDepartment(new Department(depCode, depName, depHead, depResponsibility, depSuperiorId));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(Integer depId) {
        Integer rs = service.deleteDepartment(depId);
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }


    @RequestMapping("/delAll")
    @ResponseBody
    public ResultMap deleteAll(String depIds) {
        String[] split = depIds.split(",");
        for (String depId : split) {
            service.deleteDepartment(Integer.valueOf(depId));
        }
        return ResultMap.justOk();
    }

    @RequestMapping("/loadById")
    public String loadById(Integer depId, HttpSession session) {
        Department department = service.loadDepartment(depId);
        session.setAttribute("department", department);
        return "/department_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(String depCode, String depName, String depHead, String depResponsibility, String depSuperiorId, HttpSession session) {
        Department department = (Department) session.getAttribute("department");
        Integer depId = department.getDepId();
        Integer rs = service.updateDepartment(new Department(depId,depCode,depName,depHead,depResponsibility,depSuperiorId));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/searchDepartment")
    @ResponseBody
    public ResultMap search(Integer page, Integer limit,String depNameOrDepCode) {
        PageBean<Department> pageBean = service.listByPageSearch(page, limit,depNameOrDepCode);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
