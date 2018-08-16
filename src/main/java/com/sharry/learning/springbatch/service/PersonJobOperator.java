package com.sharry.learning.springbatch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.ReferenceJobFactory;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sharry.learning.springbatch.PersonBatchApp;

//@Configuration
//@EnableBatchProcessing
//@Component
public class PersonJobOperator {
    
//    private static Logger logger = LoggerFactory.getLogger(PersonJobOperator.class);
//    
//    @Autowired
//    private JobExplorer jobExplorer;
//    @Autowired
//    private JobOperator jobOperator;
//    @Autowired
//    private JobRegistry jobRegistry;
//    
//    public List<JobInstance> getJobInstances(String jobName, int start, int count) {
//        return this.jobExplorer.getJobInstances(jobName, start, count);
//    }
//    
//    public List<JobExecution> getJobExecutions(JobInstance jobInstance) {
//        return this.jobExplorer.getJobExecutions(jobInstance);
//    }
//    
//    public Long restart(Job job, Long jobInstanceId) throws Exception {
//         this.jobRegistry.register(new ReferenceJobFactory(job));
//         return this.jobOperator.restart(jobInstanceId);
//    }
//    
//    @SuppressWarnings("resource")
//    public static void main(String[] args) throws Exception {
//        
//        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-batch-person.xml");
//        PersonJobOperator operator = (PersonJobOperator) appContext.getBean("personJobOperator");
//        PersonBatchJobConfig pjc = (PersonBatchJobConfig) appContext.getBean("personBatchJobConfig");
//        Job jobObj = pjc.job(PersonBatchApp.buildPersonDOList(10));
//        
//        List<JobInstance> instances = operator.getJobInstances("jobImportingPersons", 0, 1);
//        JobInstance jobInstance = instances.get(0);
//        logger.debug("JobInstance Info:\r\nid={}\r\ninstanceId={}\r\njob name={}", jobInstance.getId(), jobInstance.getInstanceId(), jobInstance.getJobName());
//        
//        List<JobExecution> executions = operator.getJobExecutions(jobInstance);
//        for (JobExecution jobExecution : executions) {
//            if(jobExecution.getStatus().name().equals("FAILED")) {
//                logger.debug("JobExecution info:\r\nid={}\r\nstatus={}\r\nexit status={}", jobExecution.getId(), jobExecution.getStatus().name(), jobExecution.getExitStatus());
//                operator.restart(jobObj, jobInstance.getId());
//                jobExecution.upgradeStatus(BatchStatus.COMPLETED);
//                break;
//            }
//        }
//        
//    }
    
}
