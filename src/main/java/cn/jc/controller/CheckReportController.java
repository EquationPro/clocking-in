package cn.jc.controller;

import cn.jc.entity.CheckReport;
import cn.jc.entity.Department;
import cn.jc.entity.PageBean;
import cn.jc.service.CheckReportService;
import cn.jc.service.DepartmentService;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/checkReport")
@Controller
public class CheckReportController {
    @Autowired
    private CheckReportService service;

    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap listByPage(Integer page, Integer limit) {
        PageBean<CheckReport> pageBean = service.listByPage(page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

    @RequestMapping("/loadById")
    public String loadById(Integer cheId, HttpSession session) {
        CheckReport checkReport = service.loadCheckReport(cheId);
        session.setAttribute("checkReport", checkReport);
        return "/checkreport_update.jsp";
    }

    @RequestMapping("/searchCheckReport")
    @ResponseBody
    public ResultMap search(String cheBegin, String cheEnd, String cheEmp,int page, int limit) {
        PageBean<CheckReport> pageBean = service.listLimitTimeByPage(cheBegin, cheEnd, cheEmp, page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
