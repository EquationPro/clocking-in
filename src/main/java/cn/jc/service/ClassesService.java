package cn.jc.service;

import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;

import java.util.List;

public interface ClassesService {
    //分页查
    List<Classes> list( Integer currentPage,  Integer limit);
    //分页总条数
    Integer getCountTotal();
    //增
    Integer insertClasses(Classes classes);
    //删
    Integer deleteClasses(Integer claId);
    //查找对象
    Classes loadClasses(Integer claId);
    //改
    Integer updateClasses(Classes classes);
    //pageBean分页
    PageBean<Classes> listByPage(int currentPage, int limit);
    //模糊查询
    List<Classes> listSearch( Integer currentPage, Integer limit, String claNameOrClaCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String claNameOrClaCode);
    //pageBean分页
    PageBean<Classes> listByPageSearch(int currentPage, int limit, String claNameOrClaCode);
}
