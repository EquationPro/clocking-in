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
public class PaySalary {
    private Integer payId;
    private String payEmp;
    private String payEmpName;
    private Integer paySal;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String payBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String payEnd;

    public PaySalary(String payEmp, String payEmpName, Integer paySal, String payBegin, String payEnd) {
        this.payEmp = payEmp;
        this.payEmpName = payEmpName;
        this.paySal = paySal;
        this.payBegin = payBegin;
        this.payEnd = payEnd;
    }
}
