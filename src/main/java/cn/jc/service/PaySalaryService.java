package cn.jc.service;

import cn.jc.entity.PageBean;
import cn.jc.entity.PaySalary;

import java.util.List;

public interface PaySalaryService {
    //分页查
    List<PaySalary> list(Integer currentPage, Integer limit);
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
    //pageBean分页
    PageBean<PaySalary> listByPage(int currentPage, int limit);
    //模糊查询
    List<PaySalary> listSearch( Integer currentPage, Integer limit, String payEmpNameOrPayEmp,String payBegin,String payEnd);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String payEmpNameOrPayEmp,String payBegin,String payEnd);
    //pageBean分页
    PageBean<PaySalary> listByPageSearch(int currentPage, int limit, String payEmpNameOrPayEmp,String payBegin,String payEnd);
}
