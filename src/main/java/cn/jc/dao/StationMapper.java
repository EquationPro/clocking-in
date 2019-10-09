package cn.jc.dao;



import cn.jc.entity.Station;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StationMapper {
    //分页查
    List<Station> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
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
    //查询全部
    List<Station> listAll();
    //模糊查询
    List<Station> listSearch(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit,@Param("staNameOrStaCode") String staNameOrStaCode);
    //模糊查询分页总条数
    Integer getCountTotalSearch(String staNameOrStaCode);
}
