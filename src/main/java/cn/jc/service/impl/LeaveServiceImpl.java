package cn.jc.service.impl;

import cn.jc.dao.LeaveMapper;
import cn.jc.entity.Leave;
import cn.jc.entity.PageBean;
import cn.jc.entity.Station;
import cn.jc.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper mapper;
    @Override
    public List<Leave> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit, limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertLeave(Leave leave) {
        return mapper.insertLeave(leave);
    }

    @Override
    public Integer deleteLeave(Integer leaId) {
        return mapper.deleteLeave(leaId);
    }

    @Override
    public Leave loadLeave(Integer leaId) {
        return mapper.loadLeave(leaId);
    }

    @Override
    public Integer updateLeave(Leave leave) {
        return mapper.updateLeave(leave);
    }

    @Override
    public PageBean<Leave> listByPage(int currentPage, int limit) {
        PageBean<Leave> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public List<Leave> listLimitEmpCode(Integer currentPage, Integer limit, String leaEmp) {
        return mapper.listLimitEmpCode((currentPage-1)*limit,limit,leaEmp);
    }

    @Override
    public Integer getCountTotalLimitEmpCode(String leaEmp) {
        return mapper.getCountTotalLimitEmpCode(leaEmp);
    }

    @Override
    public PageBean<Leave> listByPageLimitEmpCode(int currentPage, int limit, String leaEmp) {
        PageBean<Leave> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalLimitEmpCode(leaEmp));
        pageBean.setData(this.listLimitEmpCode(currentPage,limit,leaEmp));
        return pageBean;
    }

    @Override
    public List<Leave> listLimitTimeForPage(String leaBegin, String leaEnd, String leaEmp, Integer currentPage, Integer limit) {
        return mapper.listLimitTimeForPage(leaBegin, leaEnd, leaEmp, (currentPage-1)*limit, limit);
    }

    @Override
    public Integer getCountTotalLimitForPage(String leaBegin, String leaEnd, String leaEmp) {
        return mapper.getCountTotalLimitForPage(leaBegin, leaEnd, leaEmp);
    }

    @Override
    public PageBean<Leave> listLimitTimeByPage(String leaBegin, String leaEnd, String leaEmp, Integer currentPage, Integer limit) {
        PageBean<Leave> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalLimitForPage(leaBegin, leaEnd, leaEmp));
        pageBean.setData(this.listLimitTimeForPage(leaBegin, leaEnd, leaEmp, currentPage, limit));
        return pageBean;
    }
}
