package com.meowu.starter.jpa;

import org.springframework.data.jpa.domain.Specification;

public class Criteria<T>{

    private Specification<T> specification;

    public Criteria(){
        this.specification = Restrictions.empty();
    }

    @SafeVarargs
    public final Specification<T> where(Specification<T>... specifications){
        for(Specification<T> specification : specifications){
            this.specification = this.specification.and(specification);
        }
        return this.specification;
    }

    @SafeVarargs
    public final Specification<T> orderBy(Specification<T>... specifications){
        for(Specification<T> specification : specifications){
            this.specification = this.specification.and(specification);
        }
        return this.specification;
    }
}
