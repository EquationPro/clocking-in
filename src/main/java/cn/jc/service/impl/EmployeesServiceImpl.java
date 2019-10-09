package cn.jc.service.impl;

import cn.jc.dao.EmployeesMapper;
import cn.jc.entity.Employees;
import cn.jc.entity.PageBean;
import cn.jc.entity.Station;
import cn.jc.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesMapper mapper;
    @Override
    public List<Employees> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit,limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertEmployees(Employees employees) {
         return mapper.insertEmployees(employees);
    }

    @Override
    public Integer deleteEmployees(Integer empId) {
        return mapper.deleteEmployees(empId);
    }

    @Override
    public Employees loadEmployees(Integer empId) {
        return mapper.loadEmployees(empId);
    }

    @Override
    public Integer updateEmployees(Employees employees) {
        return mapper.updateEmployees(employees);
    }

    @Override
    public PageBean<Employees> listByPage(int currentPage, int limit) {
        PageBean<Employees> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public Employees loadByEmpCodeEmployees(String empCode) {
        return mapper.loadByEmpCodeEmployees(empCode);
    }

    @Override
    public List<Employees> listAll() {
        return mapper.listAll();
    }

    @Override
    public List<Employees> listSearch(Integer currentPage, Integer limit, String empNameOrEmpCode) {
        return mapper.listSearch((currentPage-1)*limit,limit,empNameOrEmpCode);
    }

    @Override
    public Integer getCountTotalSearch(String empNameOrEmpCode) {
        return mapper.getCountTotalSearch(empNameOrEmpCode);
    }

    @Override
    public PageBean<Employees> listByPageSearch(int currentPage, int limit, String empNameOrEmpCode) {
        PageBean<Employees> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalSearch(empNameOrEmpCode));
        pageBean.setData(this.listSearch(currentPage,limit,empNameOrEmpCode));
        return pageBean;
    }
}
