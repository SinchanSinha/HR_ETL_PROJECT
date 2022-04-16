package com.hr.employee.domain;

public class Employee {

    private String sysDate;
    private int fileId;
    private int empFileID;
    private int managerID;
    private int hrID;
    private String baseLocation;
    private String currLocation;
    private String empRole;
    private String buCD;
    private char isRetired;
    private String retiredDate;
    private String highestEducation;
    private String gradeCD;
    private String projectCD;
    private int billByWeek;

    public Employee(String sysDate, int fileId, int empFileID, int managerID, int hrID, String baseLocation, String currLocation, String empRole, String buCD, char isRetired, String retiredDate, String highestEducation, String gradeCD, String projectCD, int billByWeek) {
        this.sysDate = sysDate;
        this.fileId = fileId;
        this.empFileID = empFileID;
        this.managerID = managerID;
        this.hrID = hrID;
        this.baseLocation = baseLocation;
        this.currLocation = currLocation;
        this.empRole = empRole;
        this.buCD = buCD;
        this.isRetired = isRetired;
        this.retiredDate = retiredDate;
        this.highestEducation = highestEducation;
        this.gradeCD = gradeCD;
        this.projectCD = projectCD;
        this.billByWeek = billByWeek;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getEmpFileID() {
        return empFileID;
    }

    public void setEmpFileID(int empFileID) {
        this.empFileID = empFileID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getHrID() {
        return hrID;
    }

    public void setHrID(int hrID) {
        this.hrID = hrID;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public String getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(String currLocation) {
        this.currLocation = currLocation;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public String getBuCD() {
        return buCD;
    }

    public void setBuCD(String buCD) {
        this.buCD = buCD;
    }

    public char getIsRetired() {
        return isRetired;
    }

    public void setIsRetired(char isRetired) {
        this.isRetired = isRetired;
    }

    public String getRetiredDate() {
        return retiredDate;
    }

    public void setRetiredDate(String retiredDate) {
        this.retiredDate = retiredDate;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getGradeCD() {
        return gradeCD;
    }

    public void setGradeCD(String gradeCD) {
        this.gradeCD = gradeCD;
    }

    public String getProjectCD() {
        return projectCD;
    }

    public void setProjectCD(String projectCD) {
        this.projectCD = projectCD;
    }

    public int getBillByWeek() {
        return billByWeek;
    }

    public void setBillByWeek(int billByWeek) {
        this.billByWeek = billByWeek;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "sysDate='" + sysDate + '\'' +
                ", fileId=" + fileId +
                ", empFileID=" + empFileID +
                ", managerID=" + managerID +
                ", hrID=" + hrID +
                ", baseLocation='" + baseLocation + '\'' +
                ", currLocation='" + currLocation + '\'' +
                ", empRole='" + empRole + '\'' +
                ", buCD='" + buCD + '\'' +
                ", isRetired=" + isRetired +
                ", retiredDate='" + retiredDate + '\'' +
                ", highestEducation='" + highestEducation + '\'' +
                ", gradeCD='" + gradeCD + '\'' +
                ", projectCD='" + projectCD + '\'' +
                ", billByWeek=" + billByWeek +
                '}';
    }
}
