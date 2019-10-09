package cn.jc.service.impl;

import cn.jc.dao.ProcessMapper;
import cn.jc.entity.PageBean;
import cn.jc.entity.Process;
import cn.jc.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessMapper mapper;
    @Override
    public List<Process> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage-1)*limit, limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertProcess(Process process) {
        return mapper.insertProcess(process);
    }

    @Override
    public Integer deleteProcess(Integer proId) {
        return mapper.deleteProcess(proId);
    }

    @Override
    public Process loadProcess(Integer proId) {
        return mapper.loadProcess(proId);
    }

    @Override
    public Integer updateProcess(Process process) {
        return mapper.updateProcess(process);
    }

    @Override
    public PageBean<Process> listByPage(int currentPage, int limit) {
        PageBean<Process> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public Process loadProcessByFormId(Integer proFormId) {
        return mapper.loadProcessByFormId(proFormId);
    }

    @Override
    public List<Process> listSearch(Integer currentPage, Integer limit, Integer proFormId) {
        return mapper.listSearch((currentPage-1)*limit, limit, proFormId);
    }

    @Override
    public Integer getCountTotalSearch(Integer proFormId) {
        return mapper.getCountTotalSearch(proFormId);
    }

    @Override
    public PageBean<Process> listByPageSearch(int currentPage, int limit, Integer proFormId) {
        PageBean<Process> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalSearch(proFormId));
        pageBean.setData(this.listSearch(currentPage,limit,proFormId));
        return pageBean;
    }
}
