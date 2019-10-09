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
public class RepairCard {
    private Integer repId;
    private String repEmp;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String repTime;
    private String repReason;

    public RepairCard(String repEmp, String repTime, String repReason) {
        this.repEmp = repEmp;
        this.repTime = repTime;
        this.repReason = repReason;
    }
}
