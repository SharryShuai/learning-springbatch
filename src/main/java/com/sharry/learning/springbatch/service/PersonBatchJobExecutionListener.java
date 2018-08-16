package com.sharry.learning.springbatch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class PersonBatchJobExecutionListener implements JobExecutionListener{

    private static Logger logger = LoggerFactory.getLogger(PersonBatchJobExecutionListener.class);
    
    private String batchNumber;
    
    public PersonBatchJobExecutionListener(String batchNumber) {
        this.batchNumber = batchNumber;
    }
    
    @Override
    public void beforeJob(JobExecution jobExecution) {
        // do nothing
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (ExitStatus.COMPLETED.equals(jobExecution.getExitStatus())) {
            logger.debug("Batch job execution status:{}, batch number:{}. Batch finished.", jobExecution.getExitStatus(), this.batchNumber);
        } else {
            logger.debug("Batch job execution status:{}, batch number:{}. Batch needs to be rollback", jobExecution.getExitStatus(), this.batchNumber);
        }
        
    }

}
