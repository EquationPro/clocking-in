package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer depId;
    private String depCode;
    private String depName;
    private String depHead;
    private String depResponsibility;
    private String depSuperiorId;

    public Department(String depCode, String depName, String depHead, String depResponsibility, String depSuperiorId) {
        this.depCode = depCode;
        this.depName = depName;
        this.depHead = depHead;
        this.depResponsibility = depResponsibility;
        this.depSuperiorId = depSuperiorId;
    }
}
