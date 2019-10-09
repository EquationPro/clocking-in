package cn.jc.dao;

import cn.jc.entity.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    //分页查
    List<Process> list(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit);

    //分页总条数
    Integer getCountTotal();

    //增
    Integer insertProcess(Process process);

    //删
    Integer deleteProcess(Integer proId);

    //查找对象
    Process loadProcess(Integer proId);

    //改
    Integer updateProcess(Process process);

    //通过请假单查找对象
    Process loadProcessByFormId(Integer proFormId);

    //模糊查询
    List<Process> listSearch(@Param("currentPage") Integer currentPage, @Param("limit") Integer limit, @Param("proFormId") Integer proFormId);

    //模糊查询分页总条数
    Integer getCountTotalSearch(Integer proFormId);
}
