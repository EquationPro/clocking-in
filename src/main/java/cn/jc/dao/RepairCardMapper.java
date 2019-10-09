package cn.jc.dao;

import cn.jc.entity.RepairCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairCardMapper {
    //分页查
    List<RepairCard> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
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
    //查询一个区间内的记录分页显示
    List<RepairCard> listLimitTimeForPage(@Param("repTimeBegin") String repTimeBegin, @Param("repTimeEnd") String repTimeEnd,@Param("repEmp") String repEmp,@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(@Param("repTimeBegin") String repTimeBegin, @Param("repTimeEnd") String repTimeEnd,@Param("repEmp") String repEmp);
}
