package cn.jc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PunchCard {
    private Integer punId;
    private String punEmp;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String punTime;
    private String punRemark;

    public PunchCard(String punEmp, String punTime, String punRemark) {
        this.punEmp = punEmp;
        this.punTime = punTime;
        this.punRemark = punRemark;
    }
}
