package cn.jc.controller;


import cn.jc.entity.PageBean;
import cn.jc.entity.Station;
import cn.jc.service.StationService;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService service;

    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap listByPage(Integer page, Integer limit, HttpSession session) {
        PageBean<Station> pageBean = service.listByPage(page, limit);
        //用于获取岗位列表,存域显示于员工表和岗位的insert和update的下拉控件
        List<Station> stations = service.listAll();
        List<String> staNames = new ArrayList<>();
        List<String> staCodes = new ArrayList<>();
        for (Station station : stations) {
            staNames.add(station.getStaName());
            staCodes.add(station.getStaCode());
        }
        session.setAttribute("staNames", staNames);
        session.setAttribute("staCodes", staCodes);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(String staCode, String staName, String staDepartment, String staHead, String staCategory, String staDesc) {
        Integer rs = service.insertStation(new Station(staCode, staName, staDepartment, staHead, staCategory, staDesc));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(Integer staId) {
        Integer rs = service.deleteStation(staId);
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delAll")
    @ResponseBody
    public ResultMap deleteAll(String staIds) {
        String[] split = staIds.split(",");
        for (String staId : split) {
            service.deleteStation(Integer.valueOf(staId));
        }
        return ResultMap.justOk();
    }

    @RequestMapping("/loadById")
    public String loadById(Integer staId, HttpSession session) {
        Station station = service.loadStation(staId);
        session.setAttribute("station", station);
        return "/station_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(String staCode, String staName, String staDepartment, String staHead, String staCategory, String staDesc, HttpSession session) {
        Station station = (Station) session.getAttribute("station");
        Integer staId = station.getStaId();
        Integer rs = service.updateStation(new Station(staId, staCode, staName, staDepartment, staHead, staCategory, staDesc));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/searchStation")
    @ResponseBody
    public ResultMap search(Integer page, Integer limit,String staNameOrStaCode) {
        PageBean<Station> pageBean = service.listByPageSearch(page, limit,staNameOrStaCode);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
