package cn.jc.controller;

import cn.jc.entity.CheckReport;
import cn.jc.entity.Department;
import cn.jc.entity.PageBean;
import cn.jc.entity.PunchCard;
import cn.jc.service.CheckReportService;
import cn.jc.service.DepartmentService;
import cn.jc.service.PunchCardService;
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

@RequestMapping("/punchCard")
@Controller
public class PunchCardController {
    @Autowired
    private PunchCardService service;
    @Autowired
    private CheckReportService checkReportService;

    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap listByPage(Integer page, Integer limit) {
        PageBean<PunchCard> pageBean = service.listByPage(page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(String punEmp, String punTime, String punRemark, HttpSession session) throws ParseException {
        //获取到员工编码
        String empCode = (String) session.getAttribute("empCode");
        //进行打卡
        Integer rs = service.insertPunchCard(new PunchCard(punEmp, punTime, punRemark));
        //获取到员工姓名
        String empName = (String) session.getAttribute("empName");
        //日期比较
        SimpleDateFormat all = DateFormatUti.all();
        //获取到打卡天数作为数据库每天记录的区分
        //解析成date对象
        Date parse = all.parse(punTime);
        String checkDay = DateFormatUti.getCheckDay(parse);
        //获取到员工打卡前一天进行是否打卡判断
        Date date = new Date();
        date.setTime((parse.getTime() - (24 * 1000 * 60 * 60)));
        String beforeDay = DateFormatUti.getCheckDay(date);
        System.out.println(beforeDay);
        CheckReport cheBefore = checkReportService.loadByEmpCheckReport(empCode, beforeDay);
        //旷工的逻辑判断
        if (cheBefore.getCheBegin()==null||cheBefore.getCheEnd()==null){
            cheBefore.setCheStatus("旷工");
            checkReportService.updateCheckReport(cheBefore);
        }
        if (rs > 0) {
            //查询数据库是否存在当天记录
            CheckReport cheCurrent = checkReportService.loadByEmpCheckReport(empCode, checkDay);
            //若数据库不存在当天记录则创建记录
            if (cheCurrent == null) {
                checkReportService.insertCheckReport(new CheckReport(empCode, empName, checkDay));
            }
            //再次查询,使用新增的记录添加打卡数据
            CheckReport checkReport = checkReportService.loadByEmpCheckReport(empCode, checkDay);
            //使用数据库记录来标识是否打卡
            if (checkReport.getCheBegin() == null) {
                checkReport.setCheName(empName);
                checkReport.setCheBegin(punTime);
                //获取到小时数
                String punHour = DateFormatUti.justHour(parse);
                //对小时数进行比较判断
                if (Integer.valueOf(punHour) > 9) {
                    checkReport.setCheStatus("迟到");
                } else if (Integer.valueOf(punHour) == 9) {
                    //进行分钟数的比较
                    String punMinute = DateFormatUti.justMinute(parse);
                    if (Integer.valueOf(punMinute) > 30) {
                        checkReport.setCheStatus("迟到");
                    }
                }

            } else if (checkReport.getCheEnd() == null) {
                checkReport.setCheName(empName);
                checkReport.setCheEnd(punTime);
                //此处为最终打卡,获取首次打卡时间进行计算
                String cardFirst = checkReport.getCheBegin();
                //计算出勤小时数
                int gap = CountCardTimeUtil.countCardTimeUtil(cardFirst, punTime);
                if (gap >= 8.5) {
                    checkReport.setCheStatus("正常");
                }
                //进行小时数的比较
                //解析成date对象
//                Date parse = all.parse(punTime);
                //获取到小时数
                String punHour = DateFormatUti.justHour(parse);
                //对小时数进行比较判断
                if (Integer.valueOf(punHour) < 18) {
                    checkReport.setCheStatus("早退");
                }

            } else {
                return ResultMap.justFail();
            }
            Integer punRs = checkReportService.updateCheckReport(checkReport);
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(Integer punId) {
        Integer rs = service.deletePunchCard(punId);
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }


    @RequestMapping("/delAll")
    @ResponseBody
    public ResultMap deleteAll(String punIds) {
        String[] split = punIds.split(",");
        for (String punId : split) {
            service.deletePunchCard(Integer.valueOf(punId));
        }
        return ResultMap.justOk();
    }

    @RequestMapping("/loadById")
    public String loadById(Integer punId, HttpSession session) {
        PunchCard punchCard = service.loadPunchCard(punId);
        session.setAttribute("punchCard", punchCard);
        return "/punchcard_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(String punEmp, String punTime, String punRemark, HttpSession session) {
        PunchCard punchCard = (PunchCard) session.getAttribute("punchCard");
        Integer punId = punchCard.getPunId();
        Integer rs = service.updatePunchCard(new PunchCard(punId, punEmp, punTime, punRemark));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/searchPunchCard")
    @ResponseBody
    public ResultMap search(String punTimeBegin, String punTimeEnd, String punEmp,int page, int limit) {
        PageBean<PunchCard> pageBean = service.listLimitTimeByPage(punTimeBegin, punTimeEnd, punEmp, page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
