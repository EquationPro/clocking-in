package cn.jc.dao;

import cn.jc.entity.CheckReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckReportMapper {
    //分页查
    List<CheckReport> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
    //分页总条数
    Integer getCountTotal();
    //增
    Integer insertCheckReport(CheckReport checkReport);
    //查找对象
    CheckReport loadCheckReport(Integer cheId);
    //改
    Integer updateCheckReport(CheckReport checkReport);
    //通过员工编码和日期查找对应天数的考勤记录
    CheckReport loadByEmpCheckReport(@Param("cheEmp") String cheEmp, @Param("cheDay") String cheDay);
    //查询一个区间内的记录
    List<CheckReport> listLimitTime(@Param("cheBegin") String cheBegin, @Param("cheEnd") String cheEnd,@Param("cheEmp") String cheEmp);
    //查询一个区间内的记录分页显示
    List<CheckReport> listLimitTimeForPage(@Param("cheBegin") String cheBegin, @Param("cheEnd") String cheEnd,@Param("cheEmp") String cheEmp,@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(@Param("cheBegin") String cheBegin, @Param("cheEnd") String cheEnd,@Param("cheEmp") String cheEmp);
}
