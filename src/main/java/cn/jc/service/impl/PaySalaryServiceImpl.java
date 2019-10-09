package cn.jc.service.impl;

import cn.jc.dao.PaySalaryMapper;
import cn.jc.entity.PageBean;
import cn.jc.entity.PaySalary;
import cn.jc.entity.Station;
import cn.jc.service.PaySalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaySalaryServiceImpl implements PaySalaryService {
    @Autowired
    private PaySalaryMapper mapper;
    @Override
    public List<PaySalary> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit, limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertPaySalary(PaySalary paySalary) {
        return mapper.insertPaySalary(paySalary);
    }

    @Override
    public Integer deletePaySalary(Integer payId) {
        return mapper.deletePaySalary(payId);
    }

    @Override
    public PaySalary loadPaySalary(Integer payId) {
        return mapper.loadPaySalary(payId);
    }

    @Override
    public Integer updatePaySalary(PaySalary paySalary) {
        return mapper.updatePaySalary(paySalary);
    }

    @Override
    public PageBean<PaySalary> listByPage(int currentPage, int limit) {
        PageBean<PaySalary> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public List<PaySalary> listSearch(Integer currentPage, Integer limit, String payEmpNameOrPayEmp,String payBegin,String payEnd) {
        return mapper.listSearch((currentPage-1)*limit, limit, payEmpNameOrPayEmp,payBegin, payEnd);
    }


    @Override
    public Integer getCountTotalSearch(String payEmpNameOrPayEmp,String payBegin,String payEnd) {
        return mapper.getCountTotalSearch(payEmpNameOrPayEmp,payBegin,payEnd);
    }

    @Override
    public PageBean<PaySalary> listByPageSearch(int currentPage, int limit, String payEmpNameOrPayEmp,String payBegin,String payEnd) {
        PageBean<PaySalary> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalSearch(payEmpNameOrPayEmp,payBegin,payEnd));
        pageBean.setData(this.listSearch(currentPage,limit,payEmpNameOrPayEmp,payBegin,payEnd));
        return pageBean;
    }
}
