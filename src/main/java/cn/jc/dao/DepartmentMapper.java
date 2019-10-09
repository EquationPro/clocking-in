package cn.jc.dao;

import cn.jc.entity.Department;
import cn.jc.entity.Station;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    //分页查
    List<Department> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
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
    //查询全部
    List<Department> listAll();
    //模糊查询
    List<Department> listSearch(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit,@Param("depNameOrDepCode") String depNameOrDepCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String depNameOrDepCode);
}
