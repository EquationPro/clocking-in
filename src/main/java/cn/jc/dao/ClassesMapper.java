package cn.jc.dao;

import cn.jc.entity.Classes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassesMapper {
    //分页查
    List<Classes> list(@Param("currentPage") Integer currentPage,@Param("limit") Integer limit);
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
    //模糊查询
    List<Classes> listSearch(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit,@Param("claNameOrClaCode") String claNameOrClaCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String claNameOrClaCode);
}
