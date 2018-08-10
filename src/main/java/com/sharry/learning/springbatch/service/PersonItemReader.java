package com.sharry.learning.springbatch.service;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.batch.item.ItemReader;
import com.sharry.learning.springbatch.domain.PersonDO;

public class PersonItemReader implements ItemReader<PersonDO>{

    private ConcurrentLinkedQueue<PersonDO> queue;
    
    public PersonItemReader(List<PersonDO> list) {
        this.queue = new ConcurrentLinkedQueue<>(list);
    }
    
    @Override
    public PersonDO read() throws Exception{
        return queue.poll();
    }

}
