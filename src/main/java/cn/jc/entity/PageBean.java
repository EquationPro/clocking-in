package cn.jc.entity;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
    private  Integer countTotal;            //总计录条数
    private List<T> data = new ArrayList<>();       //数据

    public PageBean(Integer countTotal, List<T> data) {
        this.countTotal = countTotal;
        this.data = data;
    }

    public PageBean() {
    }

    public Integer getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(Integer countTotal) {
        this.countTotal = countTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
