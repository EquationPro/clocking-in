package cn.jc.service.impl;

import cn.jc.dao.CheckReportMapper;
import cn.jc.entity.CheckReport;
import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.service.CheckReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckReportServiceImpl implements CheckReportService {
    @Autowired
    private CheckReportMapper mapper;

    @Override
    public List<CheckReport> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit, limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertCheckReport(CheckReport checkReport) {
        return mapper.insertCheckReport(checkReport);
    }

    @Override
    public CheckReport loadCheckReport(Integer cheId) {
        return mapper.loadCheckReport(cheId);
    }

    @Override
    public Integer updateCheckReport(CheckReport checkReport) {
        return mapper.updateCheckReport(checkReport);
    }

    @Override
    public CheckReport loadByEmpCheckReport(String cheEmp,String cheDay) {
        return mapper.loadByEmpCheckReport(cheEmp,cheDay);
    }

    @Override
    public PageBean<CheckReport> listByPage(int currentPage, int limit) {
        PageBean<CheckReport> pageBean = new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage, limit));
        return pageBean;
    }

    @Override
    public List<CheckReport> listLimitTime(String cheBegin, String cheEnd, String cheEmp) {
        return mapper.listLimitTime(cheBegin, cheEnd,cheEmp);
    }

    @Override
    public List<CheckReport> listLimitTimeForPage(String cheBegin, String cheEnd, String cheEmp, Integer currentPage, Integer limit) {
        return mapper.listLimitTimeForPage(cheBegin, cheEnd, cheEmp, (currentPage-1)*limit, limit);
    }

    @Override
    public Integer getCountTotalLimitForPage(String cheBegin, String cheEnd, String cheEmp) {
        return mapper.getCountTotalLimitForPage(cheBegin, cheEnd, cheEmp);
    }

    @Override
    public PageBean<CheckReport> listLimitTimeByPage(String cheBegin, String cheEnd, String cheEmp,int currentPage, int limit) {
        PageBean<CheckReport> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalLimitForPage(cheBegin, cheEnd, cheEmp));
        pageBean.setData(this.listLimitTimeForPage(cheBegin,cheEnd,cheEmp,currentPage,limit));
        return pageBean;
    }


}
