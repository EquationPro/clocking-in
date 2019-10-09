package cn.jc.service;

import cn.jc.entity.Department;
import cn.jc.entity.PageBean;

import java.util.List;

public interface DepartmentService {
    //分页查
    List<Department> list( Integer currentPage, Integer limit);
    //分页总条数
    Integer getCountTotal();
    //增
    Integer insertDepartment(Department department);
    //删
    Integer deleteDepartment(Integer depId);
    //查找对象
    Department loadDepartment(Integer depId);
    //改
    Integer updateDepartment(Department department);
    //pageBean分页
    PageBean<Department> listByPage(int currentPage, int limit);
    //查询全部
    List<Department> listAll();
    //模糊查询
    List<Department> listSearch( Integer currentPage, Integer limit, String depNameOrDepCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String depNameOrDepCode);
    //pageBean分页
    PageBean<Department> listByPageSearch(int currentPage, int limit, String depNameOrDepCode);
}
