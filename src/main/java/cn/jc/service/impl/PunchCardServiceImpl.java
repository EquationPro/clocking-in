package cn.jc.service.impl;

import cn.jc.dao.PunchCardMapper;
import cn.jc.entity.PageBean;
import cn.jc.entity.PunchCard;
import cn.jc.entity.Station;
import cn.jc.service.PunchCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunchCardServiceImpl implements PunchCardService {
    @Autowired
    private PunchCardMapper mapper;
    @Override
    public List<PunchCard> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit, limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertPunchCard(PunchCard punchCard) {
        return mapper.insertPunchCard(punchCard);
    }

    @Override
    public Integer deletePunchCard(Integer punId) {
        return mapper.deletePunchCard(punId);
    }

    @Override
    public PunchCard loadPunchCard(Integer punId) {
        return mapper.loadPunchCard(punId);
    }

    @Override
    public Integer updatePunchCard(PunchCard punchCard) {
        return mapper.updatePunchCard(punchCard);
    }

    @Override
    public PageBean<PunchCard> listByPage(int currentPage, int limit) {
        PageBean<PunchCard> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public List<PunchCard> listLimitTimeForPage(String punTimeBegin, String punTimeEnd, String punEmp, Integer currentPage, Integer limit) {
        return mapper.listLimitTimeForPage(punTimeBegin, punTimeEnd, punEmp, (currentPage-1)*limit, limit);
    }

    @Override
    public Integer getCountTotalLimitForPage(String punTimeBegin, String punTimeEnd, String punEmp) {
        return mapper.getCountTotalLimitForPage(punTimeBegin, punTimeEnd, punEmp);
    }

    @Override
    public PageBean<PunchCard> listLimitTimeByPage(String punTimeBegin, String punTimeEnd, String punEmp, int currentPage, int limit) {
        PageBean<PunchCard> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalLimitForPage(punTimeBegin, punTimeEnd, punEmp));
        pageBean.setData(this.listLimitTimeForPage(punTimeBegin,punTimeEnd,punEmp,currentPage,limit));
        return pageBean;
    }
}
