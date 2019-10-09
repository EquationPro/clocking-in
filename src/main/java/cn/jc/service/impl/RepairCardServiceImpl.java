package cn.jc.service.impl;

import cn.jc.dao.RepairCardMapper;
import cn.jc.entity.PageBean;
import cn.jc.entity.RepairCard;
import cn.jc.service.RepairCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairCardServiceImpl implements RepairCardService {
    @Autowired
    private RepairCardMapper mapper;
    @Override
    public List<RepairCard> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit,limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertRepairCard(RepairCard repairCard) {
        return mapper.insertRepairCard(repairCard);
    }

    @Override
    public Integer deleteRepairCard(Integer repId) {
        return mapper.deleteRepairCard(repId);
    }

    @Override
    public RepairCard loadRepairCard(Integer repId) {
        return mapper.loadRepairCard(repId);
    }

    @Override
    public Integer updateRepairCard(RepairCard repairCard) {
        return mapper.updateRepairCard(repairCard);
    }

    @Override
    public PageBean<RepairCard> listByPage(int currentPage, int limit) {
        PageBean<RepairCard> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public List<RepairCard> listLimitTimeForPage(String repTimeBegin, String repTimeEnd, String repEmp, Integer currentPage, Integer limit) {
        return mapper.listLimitTimeForPage(repTimeBegin, repTimeEnd, repEmp, (currentPage-1)*limit, limit);
    }

    @Override
    public Integer getCountTotalLimitForPage(String repTimeBegin, String repTimeEnd, String repEmp) {
        return mapper.getCountTotalLimitForPage(repTimeBegin, repTimeEnd, repEmp);
    }

    @Override
    public PageBean<RepairCard> listLimitTimeByPage(String repTimeBegin, String repTimeEnd, String repEmp, int currentPage, int limit) {
        PageBean<RepairCard> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalLimitForPage(repTimeBegin, repTimeEnd, repEmp));
        pageBean.setData(this.listLimitTimeForPage(repTimeBegin,repTimeEnd,repEmp,currentPage,limit));
        return pageBean;
    }
}
