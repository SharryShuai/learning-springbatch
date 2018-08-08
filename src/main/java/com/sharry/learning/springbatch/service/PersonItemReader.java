package com.sharry.learning.springbatch.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.batch.item.ItemReader;
import com.sharry.learning.springbatch.domain.PersonDO;

public class PersonItemReader implements ItemReader<PersonDO>{

    private Iterator<PersonDO> iterator;
    
    public PersonItemReader(List<PersonDO> list) {
        if (list != null) {
            this.iterator = list.iterator();
        }
    }
    
    @Override
    public PersonDO read() throws Exception{
        if (iterator != null && iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

}
