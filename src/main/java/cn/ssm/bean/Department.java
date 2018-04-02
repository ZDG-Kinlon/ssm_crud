package cn.ssm.bean;

public class Department {
    //部门编号
    private Integer deptId;
    //部门名称
    private String deptName;

    public Department() {
        super();
    }

    public Department(Integer deptId, String deptName) {
        super();
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}