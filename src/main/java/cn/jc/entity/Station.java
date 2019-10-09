package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Station {
    private Integer staId;
    private String staCode;
    private String staName;
    private String staDepartment;
    private String staHead;
    private String staCategory;
    private String staDesc;

    public Station(String staCode, String staName, String staDepartment, String staHead, String staCategory, String staDesc) {
        this.staCode = staCode;
        this.staName = staName;
        this.staDepartment = staDepartment;
        this.staHead = staHead;
        this.staCategory = staCategory;
        this.staDesc = staDesc;
    }
}
