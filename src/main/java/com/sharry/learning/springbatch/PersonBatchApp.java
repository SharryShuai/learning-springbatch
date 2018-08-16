package com.sharry.learning.springbatch;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sharry.learning.springbatch.service.PersonBatchJobConfig;
import com.sharry.learning.springbatch.domain.PersonDO;

public class PersonBatchApp {
    
    private static Logger logger = LoggerFactory.getLogger(PersonBatchApp.class);
    
    public static List<PersonDO> buildPersonDOList(int count) {
        List<PersonDO> personList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            personList.add(buildPersonDO(System.currentTimeMillis() + i, "test"));
        }
        return personList;
    }
    
    private static PersonDO buildPersonDO(Long id, String name) {
        PersonDO p = new PersonDO();
        p.setId(id);
        p.setName(name);
//        p.setName(id % 2 == 0 ? null : name);
        return p;
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {        
        // Loading The Bean Definition From The Spring Configuration File
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-batch-person.xml");
        PersonBatchJobConfig pjc = (PersonBatchJobConfig) appContext.getBean("personBatchJobConfig");
        List<PersonDO> persons = PersonBatchApp.buildPersonDOList(20);
        Job jobObj = pjc.job("BATCH-NUMBER-001", persons);
        JobLauncher jobLauncher = (JobLauncher) appContext.getBean("jobLauncher");
        Long startTimeInSec = System.currentTimeMillis();
        try {
            JobExecution execution = jobLauncher.run(jobObj, new JobParameters());
            logger.debug("Batch exit status={}", execution.getStatus());
        } catch (Exception e) {
            logger.error("Batch failed", e);
        }
        Long endTimeInSec = System.currentTimeMillis();
        logger.debug("Batch finished. Cost time(ms):{}", endTimeInSec - startTimeInSec);
    }
}
