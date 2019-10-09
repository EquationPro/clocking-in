package cn.jc.service;

import cn.jc.entity.PageBean;
import cn.jc.entity.Station;

import java.util.List;

public interface StationService {
    //分页查
    List<Station> list( Integer currentPage, Integer limit);
    //分页总条数
    Integer getCountTotal();
    //增
    Integer insertStation(Station station);
    //删
    Integer deleteStation(Integer staId);
    //查找对象
    Station loadStation(Integer staId);
    //改
    Integer updateStation(Station station);
    //pageBean分页
    PageBean<Station> listByPage(int currentPage, int limit);
    //查询全部
    List<Station> listAll();
    //模糊查询
    List<Station> listSearch( Integer currentPage, Integer limit, String staNameOrStaCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String staNameOrStaCode);
    //pageBean分页
    PageBean<Station> listByPageSearch(int currentPage, int limit, String staNameOrStaCode);
}
