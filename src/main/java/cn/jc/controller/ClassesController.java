package cn.jc.controller;

import cn.jc.entity.Classes;
import cn.jc.entity.PageBean;
import cn.jc.service.ClassesService;
import cn.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService service;

    @RequestMapping("/listByPage")
    @ResponseBody
    public ResultMap list(Integer page, Integer limit) {
        PageBean<Classes> pageBean = service.listByPage(page, limit);
        return ResultMap.layuiData(pageBean.getCountTotal(),pageBean.getData());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultMap insert(String claCode, String claName, String claBegin, String claEnd, String claRemark) {
        Integer rs = service.insertClasses(new Classes(claCode,claName,claBegin,claEnd,claRemark));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultMap delete(Integer claId) {
        Integer rs = service.deleteClasses(claId);
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }


    @RequestMapping("/delAll")
    @ResponseBody
    public ResultMap deleteAll(String claIds) {
        String[] split = claIds.split(",");
        for (String claId : split) {
            service.deleteClasses(Integer.valueOf(claId));
        }
        return ResultMap.justOk();
    }

    @RequestMapping("/loadById")
    public String loadById(Integer claId, HttpSession session) {
        Classes classes = service.loadClasses(claId);
        session.setAttribute("classes", classes);
        return "/classes_update.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(String claCode, String claName, String claBegin, String claEnd, String claRemark, HttpSession session) {
        Classes classes = (Classes) session.getAttribute("classes");
        Integer claId = classes.getClaId();
        Integer rs = service.updateClasses(new Classes(claId,claCode,claName,claBegin,claEnd,claRemark));
        if (rs > 0) {
            return ResultMap.justOk();
        } else {
            return ResultMap.justFail();
        }
    }

    @RequestMapping("/searchClasses")
    @ResponseBody
    public ResultMap search(Integer page, Integer limit,String claNameOrClaCode) {
        PageBean<Classes> pageBean = service.listByPageSearch(page, limit,claNameOrClaCode);
        return ResultMap.layuiData(pageBean.getCountTotal(), pageBean.getData());
    }
}
