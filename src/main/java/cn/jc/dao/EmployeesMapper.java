package cn.jc.dao;

import cn.jc.entity.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeesMapper {
    //分页查
    List<Employees> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
    //分页总条数
    Integer getCountTotal();
    //增
    Integer insertEmployees(Employees employees);
    //删
    Integer deleteEmployees(Integer empId);
    //查找对象
    Employees loadEmployees(Integer empId);
    //改
    Integer updateEmployees(Employees employees);
    //通过员工编码查找员工对象
    Employees loadByEmpCodeEmployees(String empCode);
    //查询全部
    List<Employees> listAll();
    //模糊查询
    List<Employees> listSearch(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit,@Param("empNameOrEmpCode") String empNameOrEmpCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String empNameOrEmpCode);
}
