package cn.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employees {
    private Integer empId;
    private String empCode;
    private String empName;
    private String empSex;
    private Integer empAge;
    private String empNation;
    private String empIdentity;
    private Integer empSalary;
    private String empPhone;
    private String empContact;
    private String empContactPhone;
    private String empStationId;
    private String empCla;
    private String empDesc;

    public Employees(String empCode, String empName, String empSex, Integer empAge, String empNation, String empIdentity, Integer empSalary, String empPhone, String empContact, String empContactPhone, String empStationId, String empCla, String empDesc) {
        this.empCode = empCode;
        this.empName = empName;
        this.empSex = empSex;
        this.empAge = empAge;
        this.empNation = empNation;
        this.empIdentity = empIdentity;
        this.empSalary = empSalary;
        this.empPhone = empPhone;
        this.empContact = empContact;
        this.empContactPhone = empContactPhone;
        this.empStationId = empStationId;
        this.empCla = empCla;
        this.empDesc = empDesc;
    }
}
