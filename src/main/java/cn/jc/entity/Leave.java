package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leave {
    private Integer leaId;
    private String leaEmp;
    private String leaBegin;
    private String leaEnd;
    private String leaReason;
    private String leaState;


    public Leave(String leaEmp, String leaBegin, String leaEnd, String leaReason, String leaState) {
        this.leaEmp = leaEmp;
        this.leaBegin = leaBegin;
        this.leaEnd = leaEnd;
        this.leaReason = leaReason;
        this.leaState = leaState;
    }
}
