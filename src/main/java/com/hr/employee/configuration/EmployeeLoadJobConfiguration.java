package com.hr.employee.configuration;

import com.hr.employee.domain.Employee;
import com.hr.employee.domain.EmployeeFieldSetMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class EmployeeLoadJobConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    public FlatFileItemReader<Employee> employeeItemReader(){

        FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();

        flatFileItemReader.setResource(new ClassPathResource("/input/EmployeeData.csv"));
        flatFileItemReader.setLinesToSkip(1);

        DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames(new String[]{"sysDate", "fileId", "empFileID",
                                         "managerID", "hrID", "baseLocation", "currLocation",
                                            "empRole", "buCD", "isRetired", "retiredDate",
                                            "highestEducation", "gradeCD", "projectCD", "billByWeek"});

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(new EmployeeFieldSetMapper());
        defaultLineMapper.afterPropertiesSet();

        flatFileItemReader.setLineMapper(defaultLineMapper);

        return flatFileItemReader;
    }

    @Bean
    public JdbcBatchItemWriter<Employee> employeeItemWriter(){

        JdbcBatchItemWriter<Employee> jdbcBatchItemWriter = new JdbcBatchItemWriter<>();

        jdbcBatchItemWriter.setDataSource(this.dataSource);
        jdbcBatchItemWriter.setSql("BEGIN " +
                "HR_EMPLOYEE_PKG.load_emp_stage(:sysDate, :fileId, :empFileID ,:managerID, :hrID, :baseLocation, :currLocation, :empRole, :buCD, :isRetired, :retiredDate, :highestEducation, :gradeCD, :projectCD, :billByWeek); " +
                "END;");
        //jdbcBatchItemWriter.setSql("INSERT INTO HR_EMPLOYEE_STAGE VALUES(:sysDate, :empFileID ,:managerID, :hrID, :baseLocation, :currLocation, :empRole, :buCD, :isRetired, :retiredDate, :highestEducation, :gradeCD, :projectCD, :billByWeek, :firstName, :lastName)");
        jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
        jdbcBatchItemWriter.afterPropertiesSet();

        return jdbcBatchItemWriter;

    }

    @Bean
    public Step writeEmployeeDataStep() {
        return stepBuilderFactory.get("writeEmployeeDataStep")
                .<Employee, Employee>chunk(10)
                .reader(employeeItemReader())
                .writer(employeeItemWriter())
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Job employeeLoaderJob(){
        return jobBuilderFactory.get("employeeLoaderJob")
                .start(writeEmployeeDataStep())
                .build();
    }




}
