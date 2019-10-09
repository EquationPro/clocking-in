package cn.jc.service.impl;

import cn.jc.dao.LoginMapper;
import cn.jc.entity.Login;
import cn.jc.entity.PageBean;
import cn.jc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper mapper;

    @Override
    public Login login(String username, String password) {
        return mapper.login(username, password);
    }

    @Override
    public List<Login> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit, limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertLogin(Login login) {
        return mapper.insertLogin(login);
    }

    @Override
    public Integer deleteLogin(Integer id) {
        return mapper.deleteLogin(id);
    }

    @Override
    public Login loadLogin(Integer id) {
        return mapper.loadLogin(id);
    }

    @Override
    public Integer updateLogin(Login login) {
        return mapper.updateLogin(login);
    }

    @Override
    public PageBean<Login> listByPage(int currentPage, int limit) {
        PageBean<Login> pageBean = new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage, limit));
        return pageBean;
    }
}
