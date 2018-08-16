package com.sharry.learning.springbatch.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class PersonDO {

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
