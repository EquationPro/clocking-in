package cn.jc.service;

import cn.jc.entity.Leave;
import cn.jc.entity.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveService {
    //分页查
    List<Leave> list(Integer currentPage, Integer limit);

    //分页总条数
    Integer getCountTotal();

    //增
    Integer insertLeave(Leave leave);

    //删
    Integer deleteLeave(Integer leaId);

    //查找对象
    Leave loadLeave(Integer leaId);

    //改
    Integer updateLeave(Leave leave);

    //pageBean分页
    PageBean<Leave> listByPage(int currentPage, int limit);

    //通过用户编码查找请假单记录
    List<Leave> listLimitEmpCode(Integer currentPage, Integer limit, String leaEmp);

    //通过用户编码查找请假单记录分页总条数
    Integer getCountTotalLimitEmpCode(String leaEmp);

    //通过用户编码查找请假单记录pageBean分页
    PageBean<Leave> listByPageLimitEmpCode(int currentPage, int limit , String leaEmp);


    //查询一个区间内的记录分页显示
    List<Leave> listLimitTimeForPage(String leaBegin, String leaEnd, String leaEmp, Integer currentPage, Integer limit);

    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(String leaBegin, String leaEnd, String leaEmp);

    //pageBean分页
    PageBean<Leave> listLimitTimeByPage(String leaBegin, String leaEnd, String leaEmp, Integer currentPage, Integer limit);
}
