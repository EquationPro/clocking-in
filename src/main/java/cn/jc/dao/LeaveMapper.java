package cn.jc.dao;

import cn.jc.entity.Leave;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveMapper {
    //分页查
    List<Leave> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);

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

    //通过用户编码查找请假单记录
    List<Leave> listLimitEmpCode(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit, @Param("leaEmp") String leaEmp);

    //通过用户编码查找请假单记录分页总条数
    Integer getCountTotalLimitEmpCode(String leaEmp);

    //查询一个区间内的记录分页显示
    List<Leave> listLimitTimeForPage(@Param("leaBegin") String leaBegin, @Param("leaEnd") String leaEnd, @Param("leaEmp") String leaEmp, @Param("currentPage") Integer currentPage, @Param("limit") Integer limit);

    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(@Param("leaBegin") String leaBegin, @Param("leaEnd") String leaEnd, @Param("leaEmp") String leaEmp);
}
