package cn.jc.controller;

import cn.jc.entity.Classes;
import cn.jc.entity.Leave;
import cn.jc.entity.PageBean;
import cn.jc.entity.Process;
import cn.jc.service.ClassesService;
import cn.jc.service.LeaveService;
import cn.jc.service.ProcessService;
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

@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private LeaveService service;

    @RequestMapping("/listByPageLimitEmpCode")
    @ResponseBody
    public ResultMap listLimitEmpCode(Integer page, Integer limit,HttpSession session) {
        String empCode = (String) session.getAttribute("empCode");
        PageBean<Leave> pageBean = service.listByPageLimitEmpCode(page, limit,empCode);
        return ResultMap.layuiData(pageBean.getCountTotal(),pageBean.getData());
    }


    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap list(Integer page, Integer limit) {
        PageBean<Leave> pageBean = service.listByPage(page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(),pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(String leaEmp, String leaBegin, String leaEnd, String leaReason) throws ParseException {
        String leaState="保存";
        SimpleDateFormat all = DateFormatUti.all();
        Date parseBegin = all.parse(leaBegin);
        Date parseEnd = all.parse(leaEnd);
        int gap = new Long((parseEnd.getTime()-parseBegin.getTime()) / (1000 * 60)).intValue();
        if (gap%30 !=0 ){
            return ResultMap.justFail();
        }
        System.out.println(gap);
        Integer rs = service.insertLeave(new Leave(leaEmp,leaBegin,leaEnd,leaReason,leaState));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(Integer leaId) {
        Integer rs = service.deleteLeave(leaId);
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }


    @RequestMapping("/delAll")
    @ResponseBody
    public ResultMap deleteAll(String leaIds) {
        String[] split = leaIds.split(",");
        for (String leaId : split) {
            service.deleteLeave(Integer.valueOf(leaId));
        }
        return ResultMap.justOk();
    }

    @RequestMapping("/loadById")
    public String loadById(Integer leaId, HttpSession session) {
        Leave leave = service.loadLeave(leaId);
        session.setAttribute("leave", leave);
        return "/leave_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(String leaEmp, String leaBegin, String leaEnd, String leaReason,String leaState,HttpSession session) {
        Leave leave = (Leave) session.getAttribute("leave");
        Integer leaId = leave.getLeaId();
        Integer rs = service.updateLeave(new Leave(leaId,leaEmp,leaBegin,leaEnd,leaReason,leaState));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/searchLeave")
    @ResponseBody
    public ResultMap search(String leaBegin, String leaEnd, String leaEmp,int page, int limit) {
        PageBean<Leave> pageBean = service.listLimitTimeByPage(leaBegin,leaEnd,leaEmp,page,limit);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
