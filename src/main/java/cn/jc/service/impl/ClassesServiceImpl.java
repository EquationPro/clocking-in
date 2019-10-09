package cn.jc.service.impl;

import cn.jc.dao.ClassesMapper;
import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper mapper;
    @Override
    public List<Classes> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit, limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertClasses(Classes classes) {
        return mapper.insertClasses(classes);
    }

    @Override
    public Integer deleteClasses(Integer claId) {
        return mapper.deleteClasses(claId);
    }

    @Override
    public Classes loadClasses(Integer claId) {
        return mapper.loadClasses(claId);
    }

    @Override
    public Integer updateClasses(Classes classes) {
        return mapper.updateClasses(classes);
    }

    @Override
    public PageBean<Classes> listByPage(int currentPage, int limit) {
        PageBean<Classes> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public List<Classes> listSearch(Integer currentPage, Integer limit, String claNameOrClaCode) {
        return mapper.listSearch((currentPage-1)*limit, limit, claNameOrClaCode);
    }

    @Override
    public Integer getCountTotalSearch(String claNameOrClaCode) {
        return mapper.getCountTotalSearch(claNameOrClaCode);
    }

    @Override
    public PageBean<Classes> listByPageSearch(int currentPage, int limit, String claNameOrClaCode) {
        PageBean<Classes> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalSearch(claNameOrClaCode));
        pageBean.setData(this.listSearch(currentPage,limit,claNameOrClaCode));
        return pageBean;
    }
}
