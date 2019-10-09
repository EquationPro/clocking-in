package cn.jc.service.impl;

import cn.jc.dao.DepartmentMapper;
import cn.jc.entity.Department;
import cn.jc.entity.PageBean;
import cn.jc.entity.Station;
import cn.jc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper mapper;
    @Override
    public List<Department> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit,limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertDepartment(Department department) {
        return mapper.insertDepartment(department);
    }

    @Override
    public Integer deleteDepartment(Integer depId) {
        return mapper.deleteDepartment(depId);
    }

    @Override
    public Department loadDepartment(Integer depId) {
        return mapper.loadDepartment(depId);
    }

    @Override
    public Integer updateDepartment(Department department) {
        return mapper.updateDepartment(department);
    }

    @Override
    public PageBean<Department> listByPage(int currentPage, int limit) {
        PageBean<Department> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public List<Department> listAll() {
        return mapper.listAll();
    }

    @Override
    public List<Department> listSearch(Integer currentPage, Integer limit, String depName) {
        return mapper.listSearch((currentPage-1)*limit, limit, depName);
    }

    @Override
    public Integer getCountTotalSearch(String depName) {
        return mapper.getCountTotalSearch(depName);
    }

    @Override
    public PageBean<Department> listByPageSearch(int currentPage, int limit, String depNameOrDepCode) {
        PageBean<Department> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalSearch(depNameOrDepCode));
        pageBean.setData(this.listSearch(currentPage,limit,depNameOrDepCode));
        return pageBean;
    }
}
