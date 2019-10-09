package cn.jc.service;

import cn.jc.entity.Login;
import cn.jc.entity.PageBean;


import java.util.List;

public interface LoginService {
    Login login(String username, String password);
    //分页查
    List<Login> list( Integer currentPage,  Integer limit);
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
    //pageBean分页
    PageBean<Login> listByPage(int currentPage, int limit);
}
