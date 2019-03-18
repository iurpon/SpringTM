package ru.trandefil.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractEntity {

    protected String id ;

    public AbstractEntity(String id) {
        this.id = id;
    }

    public boolean isNew(){
        return id == null;
    }

}
