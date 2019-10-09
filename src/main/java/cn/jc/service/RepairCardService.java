package cn.jc.service;

import cn.jc.entity.PageBean;
import cn.jc.entity.RepairCard;

import java.util.List;

public interface RepairCardService {
    //分页查
    List<RepairCard> list( Integer currentPage, Integer limit);
    //分页总条数
    Integer getCountTotal();
    //增
    Integer insertRepairCard(RepairCard repairCard);
    //删
    Integer deleteRepairCard(Integer repId);
    //查找对象
    RepairCard loadRepairCard(Integer repId);
    //改
    Integer updateRepairCard(RepairCard repairCard);
    //pageBean分页
    PageBean<RepairCard> listByPage(int currentPage, int limit);
    //查询一个区间内的记录分页显示
    List<RepairCard> listLimitTimeForPage(String repTimeBegin, String repTimeEnd, String repEmp, Integer currentPage, Integer limit);

    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(String repTimeBegin, String repTimeEnd, String repEmp);

    //pageBean分页
    PageBean<RepairCard> listLimitTimeByPage(String repTimeBegin, String repTimeEnd, String repEmp, int currentPage, int limit);
}
