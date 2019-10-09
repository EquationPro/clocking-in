package cn.jc.controller;

import cn.jc.entity.Classes;
import cn.jc.entity.Leave;
import cn.jc.entity.PageBean;
import cn.jc.entity.Process;
import cn.jc.service.ClassesService;
import cn.jc.service.LeaveService;
import cn.jc.service.ProcessService;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    private ProcessService service;
    @Autowired
    private LeaveService leaveService;
    int i = 0;
    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap list(Integer page, Integer limit) {
        PageBean<Process> pageBean = service.listByPage(page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(Integer leaId, String leaEmp, String leaBegin, String leaEnd, String leaReason, String leaState,HttpSession session) {
        if ("批准".equals(leaState) || "驳回".equals(leaState)||"待审核".equals(leaState)) {
            return ResultMap.justFail();
        }
        String state = "待审核";
        Integer rs = service.insertProcess(new Process(leaId, leaEmp, leaEmp, state));
        if (rs > 0) {
            //计算待审核数量并存域显示于前台
            i++;
            session.getServletContext().setAttribute("auditMessage",i);
            //同步修改请假单内容
            leaveService.updateLeave(new Leave(leaId, leaEmp, leaBegin, leaEnd, leaReason, state));
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/loadById")
    public String loadById(Integer proId, HttpSession session) {
        Process process = service.loadProcess(proId);
        session.setAttribute("process", process);
        return "/process_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(Integer proFormId, String proEmp, String proExamine, String proState, HttpSession session) {
        Process process = (Process) session.getAttribute("process");
        Integer proId = process.getProId();
        Integer rs = service.updateProcess(new Process(proId,proFormId,proEmp,proExamine,proState));
        if (rs > 0) {
            //计算待审核数量并存域显示于前台
            i--;
            session.getServletContext().setAttribute("auditMessage",i);
            Leave leave = leaveService.loadLeave(proFormId);
            leave.setLeaState(proState);
            leaveService.updateLeave(leave);
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }


    @RequestMapping("/auditRecall")
    @ResponseBody
    public ResultMap auditRecall(Integer leaId, String leaEmp, String leaBegin, String leaEnd, String leaReason, String leaState,HttpSession session) {
       if ("批准".equals(leaState) || "驳回".equals(leaState)||"保存".equals(leaState)) {
            return ResultMap.justFail();
        }
        String state = "撤回";
        Process process = service.loadProcessByFormId(leaId);
        process.setProState(state);
        Integer rs = service.updateProcess(process);
        if (rs > 0) {
            //计算待审核数量并存域显示于前台
            i--;
            session.getServletContext().setAttribute("auditMessage",i);
            //同步修改请假单内容
            leaveService.updateLeave(new Leave(leaId, leaEmp, leaBegin, leaEnd, leaReason, state));
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }


    @RequestMapping("/audit")
    @ResponseBody
    public Map auditMessage(HttpSession session) {
        Map<String, Object> rsMap = new HashMap<>();
        if (session.getServletContext().getAttribute("auditMessage") == null) {
            rsMap.put("code", 500);
            rsMap.put("count", 0);
            return rsMap;
        } else {
            int audit = (int) session.getServletContext().getAttribute("auditMessage");
            rsMap.put("code", 200);
            rsMap.put("count", audit);
            System.out.println(audit);
            return rsMap;
        }
    }

    @RequestMapping("/searchProcess")
    @ResponseBody
    public ResultMap search(Integer page, Integer limit,Integer proFormId) {
        PageBean<Process> pageBean = service.listByPageSearch(page, limit,proFormId);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
