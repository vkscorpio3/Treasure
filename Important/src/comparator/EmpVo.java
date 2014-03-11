/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

/**
 *
 * @author ganesan
 */
import java.io.Serializable;

public class EmpVo implements Serializable {

    private static final long serialVersionUID = -5582930215624470075L;
    String empName;
    String empDept;
    int empAge;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }
}