package com.sharry.learning.springbatch.service;

import java.util.List;
import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import com.sharry.learning.springbatch.domain.PersonDO;

@Configuration
@EnableBatchProcessing
public class PersonBatchJobConfig {
    
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    @Qualifier("hibernateItemWriter")
    private HibernateItemWriter<PersonDO> writer;
    
    
    
    public Job job(List<PersonDO> personList) {
        return jobBuilderFactory.get("jobImportingPersons")
            .incrementer(new RunIdIncrementer())
            .flow(step(personList))
            .end()
            .build();
    }
    
    private Step step(List<PersonDO> personList) {
        return stepBuilderFactory.get("stepImportingPersons-" + UUID.randomUUID().toString())
            .<PersonDO, PersonDO> chunk(100)
            .reader(reader(personList))
            .writer(writer)
            .build();
    }
    
    private ItemReader<PersonDO> reader(List<PersonDO> batchList) {
        return new PersonItemReader(batchList);
    }

}
