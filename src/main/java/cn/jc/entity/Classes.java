package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    private Integer claId;
    private String claCode;
    private String claName;
    private String claBegin;
    private String claEnd;
    private String claRemark;

    public Classes(String claCode, String claName, String claBegin, String claEnd, String claRemark) {
        this.claCode = claCode;
        this.claName = claName;
        this.claBegin = claBegin;
        this.claEnd = claEnd;
        this.claRemark = claRemark;
    }
}
