package com.hr.employee.domain;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {


    @Override
    public Employee mapFieldSet(FieldSet fieldSet) throws BindException {

        return new Employee(fieldSet.readString("sysDate"),
                fieldSet.readInt("fileId"),
                fieldSet.readInt("empFileID"),
                fieldSet.readInt("managerID"),
                fieldSet.readInt("hrID"),
                fieldSet.readString("baseLocation"),
                fieldSet.readString("currLocation"),
                fieldSet.readString("empRole"),
                fieldSet.readString("buCD"),
                fieldSet.readChar("isRetired"),
                fieldSet.readString("retiredDate"),
                fieldSet.readString("highestEducation"),
                fieldSet.readString("gradeCD"),
                fieldSet.readString("projectCD"),
                fieldSet.readInt("billByWeek"));
    }
}
