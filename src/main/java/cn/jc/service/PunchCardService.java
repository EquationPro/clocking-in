package cn.jc.service;

import cn.jc.entity.PageBean;
import cn.jc.entity.PunchCard;

import java.util.List;

public interface PunchCardService {
    //分页查
    List<PunchCard> list(Integer currentPage, Integer limit);

    //分页总条数
    Integer getCountTotal();

    //增
    Integer insertPunchCard(PunchCard punchCard);

    //删
    Integer deletePunchCard(Integer punId);

    //查找对象
    PunchCard loadPunchCard(Integer punId);

    //改
    Integer updatePunchCard(PunchCard punchCard);

    //pageBean分页
    PageBean<PunchCard> listByPage(int currentPage, int limit);

    //查询一个区间内的记录分页显示
    List<PunchCard> listLimitTimeForPage(String punTimeBegin, String punTimeEnd, String punEmp, Integer currentPage, Integer limit);

    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(String punTimeBegin, String punTimeEnd, String punEmp);

    //pageBean分页
    PageBean<PunchCard> listLimitTimeByPage(String punTimeBegin, String punTimeEnd, String punEmp, int currentPage, int limit);
}
