package cn.jc.dao;

import cn.jc.entity.PaySalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaySalaryMapper {
    //分页查
    List<PaySalary> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
    //分页总条数
    Integer getCountTotal();
    //增
    Integer insertPaySalary(PaySalary paySalary);
    //删
    Integer deletePaySalary(Integer payId);
    //查找对象
    PaySalary loadPaySalary(Integer payId);
    //改
    Integer updatePaySalary(PaySalary paySalary);
    //模糊查询
    List<PaySalary> listSearch(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit,@Param("payEmpNameOrPayEmp") String payEmpNameOrPayEmp,@Param("payBegin") String payBegin,@Param("payEnd") String payEnd);
    //模糊查询分页总条数
    Integer getCountTotalSearch(@Param("payEmpNameOrPayEmp") String payEmpNameOrPayEmp,@Param("payBegin") String payBegin,@Param("payEnd") String payEnd);
}
