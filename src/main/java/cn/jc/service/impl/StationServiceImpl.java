package cn.jc.service.impl;

import cn.jc.dao.StationMapper;
import cn.jc.entity.PageBean;
import cn.jc.entity.Station;
import cn.jc.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationMapper mapper;
    @Override
    public List<Station> list(Integer currentPage, Integer limit) {
        return mapper.list((currentPage - 1) * limit,limit);
    }

    @Override
    public Integer getCountTotal() {
        return mapper.getCountTotal();
    }

    @Override
    public Integer insertStation(Station station) {
        return mapper.insertStation(station);
    }

    @Override
    public Integer deleteStation(Integer staId) {
        return mapper.deleteStation(staId);
    }

    @Override
    public Station loadStation(Integer staId) {
        return mapper.loadStation(staId);
    }

    @Override
    public Integer updateStation(Station station) {
        return mapper.updateStation(station);
    }

    @Override
    public PageBean<Station> listByPage(int currentPage, int limit) {
        PageBean<Station> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotal());
        pageBean.setData(this.list(currentPage,limit));
        return pageBean;
    }

    @Override
    public List<Station> listAll() {
        return mapper.listAll();
    }

    @Override
    public List<Station> listSearch(Integer currentPage, Integer limit, String staNameOrStaCode) {
        return mapper.listSearch((currentPage-1)*limit,limit,staNameOrStaCode);
    }

    @Override
    public Integer getCountTotalSearch(String staNameOrStaCode) {
        return mapper.getCountTotalSearch(staNameOrStaCode);
    }

    @Override
    public PageBean<Station> listByPageSearch(int currentPage, int limit, String staNameOrStaCode) {
        PageBean<Station> pageBean =new PageBean<>();
        pageBean.setCountTotal(this.getCountTotalSearch(staNameOrStaCode));
        pageBean.setData(this.listSearch(currentPage,limit,staNameOrStaCode));
        return pageBean;
    }

}
