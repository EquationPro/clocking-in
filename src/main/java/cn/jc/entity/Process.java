package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Process {
    private Integer proId;
    private Integer proFormId;
    private String proEmp;
    private String proExamine;
    private String proState;

    public Process(Integer proFormId, String proEmp, String proExamine, String proState) {
        this.proFormId = proFormId;
        this.proEmp = proEmp;
        this.proExamine = proExamine;
        this.proState = proState;
    }
}
