package cn.jc.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultMap {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;


    public static ResultMap justOk(){
        return  new ResultMap(200,"成功",0,null);
    }
    public static ResultMap justFail(){
        return  new ResultMap(500,"失败",0,null);
    }
    public static ResultMap ok(Object data){
        return  new ResultMap(200,"成功",0,data);
    }

    public static ResultMap fail(Object data){
        return  new ResultMap(500,"失败",0,data);
    }
    public static ResultMap extra(Integer code,String msg){
        return  new ResultMap(code,msg,0,null);
    }

    public static ResultMap msgOk(String msg){
        return  new ResultMap(200,msg,0,null);
    }
    public static ResultMap msgFail(String msg){
        return  new ResultMap(500,msg,0,null);
    }
    public static ResultMap layuiData(Integer count,Object data){
        return  new ResultMap(0,"",count,data);
    }
}
