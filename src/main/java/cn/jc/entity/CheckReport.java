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
public class CheckReport {
    private Integer cheId;
    private String cheEmp;
    private String cheName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String cheBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String cheEnd;
    private String cheStatus;
    private String cheDay;

    public CheckReport(String cheEmp, String cheName, String cheDay) {
        this.cheEmp = cheEmp;
        this.cheName = cheName;
        this.cheDay = cheDay;
    }
}
