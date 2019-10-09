package cn.jc.service;

import cn.jc.entity.Employees;
import cn.jc.entity.PageBean;

import java.util.List;

public interface EmployeesService {
    //分页查
    List<Employees> list( Integer currentPage,  Integer limit);
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
    //pageBean分页
    PageBean<Employees> listByPage(int currentPage, int limit);
    //通过员工编码查找员工对象
    Employees loadByEmpCodeEmployees(String empCode);
    //查询全部
    List<Employees> listAll();
    //模糊查询
    List<Employees> listSearch( Integer currentPage, Integer limit, String empNameOrEmpCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String empNameOrEmpCode);
    //pageBean分页
    PageBean<Employees> listByPageSearch(int currentPage, int limit,String empNameOrEmpCode);
}
