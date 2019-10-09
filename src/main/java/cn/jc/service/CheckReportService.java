package cn.jc.service;

import cn.jc.entity.CheckReport;
import cn.jc.entity.PageBean;

import java.util.List;

public interface CheckReportService {
    //分页查
    List<CheckReport> list(Integer currentPage, Integer limit);

    //分页总条数
    Integer getCountTotal();

    //增
    Integer insertCheckReport(CheckReport checkReport);

    //查找对象
    CheckReport loadCheckReport(Integer cheId);

    //改
    Integer updateCheckReport(CheckReport checkReport);

    //通过员工编码和日期查找对应天数的考勤记录
    CheckReport loadByEmpCheckReport(String cheEmp, String cheDay);

    //pageBean分页
    PageBean<CheckReport> listByPage(int currentPage, int limit);

    //查询一个区间内的记录
    List<CheckReport> listLimitTime(String cheBegin, String cheEnd, String cheEmp);

    //查询一个区间内的记录分页显示
    List<CheckReport> listLimitTimeForPage(String cheBegin, String cheEnd, String cheEmp, Integer currentPage, Integer limit);

    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(String cheBegin, String cheEnd, String cheEmp);

    //pageBean分页
    PageBean<CheckReport> listLimitTimeByPage(String cheBegin, String cheEnd, String cheEmp,int currentPage, int limit);
}
