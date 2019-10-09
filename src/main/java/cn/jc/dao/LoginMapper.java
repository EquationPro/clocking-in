package cn.jc.dao;

import cn.jc.entity.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
  Login login(@Param("username") String username,@Param("password") String password);
  //分页查
  List<Login> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
  //分页总条数
  Integer getCountTotal();
  //增
  Integer insertLogin(Login login);
  //删
  Integer deleteLogin(Integer id);
  //查找对象
  Login loadLogin(Integer id);
  //改
  Integer updateLogin(Login login);
}
