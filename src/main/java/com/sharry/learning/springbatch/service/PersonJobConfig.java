package com.sharry.learning.springbatch.service;

import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.HibernateItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import com.sharry.learning.springbatch.domain.PersonDO;

@Configuration
@EnableBatchProcessing
public class PersonJobConfig {
    
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    @Qualifier("hibernateItemWriter")
    private HibernateItemWriter<PersonDO> writer;
    
    public ItemReader<PersonDO> reader(List<PersonDO> batchList) {
        return new ListItemReader<PersonDO>(batchList);
    }
    
    public Job jobImportingBalance(List<PersonDO> personList) {
        return jobBuilderFactory.get("jobImportingBalance")
            .incrementer(new RunIdIncrementer())
            // .listener(listener)
            .flow(stepImportingBalance(personList))
            .end()
            .build();
    }
    
    public Step stepImportingBalance(List<PersonDO> personList) {
        return stepBuilderFactory.get("stepImportingBalance")
            .<PersonDO, PersonDO> chunk(50)
            .reader(reader(personList))
            .writer(writer)
            .build();
    }

}
