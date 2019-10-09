package cn.jc.controller;

import cn.jc.entity.CheckReport;
import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.entity.PaySalary;
import cn.jc.service.CheckReportService;
import cn.jc.service.ClassesService;
import cn.jc.service.PaySalaryService;
import cn.jc.util.CountCardTimeUtil;
import cn.jc.util.DateFormatUti;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/paySalary")
public class PaySalaryController {
    @Autowired
    private PaySalaryService service;
    @Autowired
    private CheckReportService checkReportService;

    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap list(Integer page, Integer limit) {
        PageBean<PaySalary> pageBean = service.listByPage(page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(String payEmp, String payEmpName, Integer paySal, String payBegin, String payEnd) {
        Integer rs = service.insertPaySalary(new PaySalary(payEmp, payEmpName, paySal, payBegin, payEnd));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(Integer payId) {
        Integer rs = service.deletePaySalary(payId);
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }


    @RequestMapping("/delAll")
    @ResponseBody
    public ResultMap deleteAll(String payIds) {
        String[] split = payIds.split(",");
        for (String payId : split) {
            service.deletePaySalary(Integer.valueOf(payId));
        }
        return ResultMap.justOk();
    }

    @RequestMapping("/loadById")
    public String loadById(Integer payId, HttpSession session) {
        PaySalary paySalary = service.loadPaySalary(payId);
        session.setAttribute("paySalary", paySalary);
        return "/paysalary_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(String payEmp, String payEmpName, Integer paySal, String payBegin, String payEnd, HttpSession session) {
        PaySalary paySalary = (PaySalary) session.getAttribute("paySalary");
        Integer payId = paySalary.getPayId();
        Integer rs = service.updatePaySalary(new PaySalary(payId, payEmp, payEmpName, paySal, payBegin, payEnd));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/countSal")
    @ResponseBody
    public Map countSal(Integer paySal, String payBegin, String payEnd,String payEmp) throws ParseException {
        List<CheckReport> checkReports = checkReportService.listLimitTime(payBegin, payEnd,payEmp);
        int count = 0;
        int i =0;
        for (CheckReport checkReport : checkReports) {
            Integer gap = CountCardTimeUtil.countCardTimeUtil(checkReport.getCheBegin(), checkReport.getCheEnd());
            i++;
            count += gap;
        }
        Map<String, Object> rsMap = new HashMap<>();
        rsMap.put("code", 200);
        rsMap.put("salary", paySal*count/(i*8));
        return rsMap;
    }

    @RequestMapping("/searchPaySalary")
    @ResponseBody
    public ResultMap search(Integer page, Integer limit,String payEmpNameOrPayEmp,String payBegin,String payEnd) {
        PageBean<PaySalary> pageBean = service.listByPageSearch(page, limit,payEmpNameOrPayEmp,payBegin,payEnd);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
