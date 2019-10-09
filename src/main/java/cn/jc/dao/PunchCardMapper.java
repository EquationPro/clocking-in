package cn.jc.dao;

import cn.jc.entity.PunchCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PunchCardMapper {
    //分页查
    List<PunchCard> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
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
    //查询一个区间内的记录分页显示
    List<PunchCard> listLimitTimeForPage(@Param("punTimeBegin") String punTimeBegin, @Param("punTimeEnd") String punTimeEnd,@Param("punEmp") String punEmp,@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);
    //查询一个区间内的记录分页总条数
    Integer getCountTotalLimitForPage(@Param("punTimeBegin") String punTimeBegin, @Param("punTimeEnd") String punTimeEnd,@Param("punEmp") String punEmp);
}
