package com.meowu.starter.jpa;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;

public class Restrictions{

    public static <T> Specification<T> empty(){
        return (root, query, cb) -> null;
    }

    public static <T> Specification<T> equal(String field, Object value){
        return (root, query, cb) -> cb.equal(root.get(field), value);
    }

    public static <T> Specification<T> notEqual(String field, Object value){
        return (root, query, cb) -> cb.notEqual(root.get(field), value);
    }

    public static <T, Y extends Comparable<? super Y>> Specification<T> lessThan(String field, Y value){
        return (root, query, cb) -> cb.lessThan(root.get(field), value);
    }

    public static <T, Y extends Comparable<? super Y>> Specification<T> lessThanOrEqual(String field, Y value){
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get(field), value);
    }

    public static <T, Y extends Comparable<? super Y>> Specification<T> greaterThan(String field, Y value){
        return (root, query, cb) -> cb.greaterThan(root.get(field), value);
    }

    public static <T, Y extends Comparable<? super Y>> Specification<T> greaterThanOrEqual(String field, Y value){
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get(field), value);
    }

    public static <T, Y extends Comparable<? super Y>> Specification<T> between(String field, Y min, Y max){
        return (root, query, cb) -> cb.between(root.get(field), min, max);
    }

    public static <T, Y> Specification<T> in(String field, List<Y> values){
        return (root, query, cb) -> cb.in(root.get(field)).value(values);
    }

    public static <T, Y> Specification<T> notIn(String field, List<Y> values){
        return (root, query, cb) -> cb.in(root.get(field)).value(values).not();
    }

    public static <T> Specification<T> like(String field, String value){
        return (root, query, cb) -> cb.like(root.get(field), "%" + value + "%");
    }

    public static <T> Specification<T> notLike(String field, String value){
        return (root, query, cb) -> cb.notLike(root.get(field), "%" + value + "%");
    }

    public static <T> Specification<T> isNotNull(String field){
        return (root, query, cb) -> cb.isNotNull(root.get(field));
    }

    public static <T> Specification<T> isNull(String field){
        return (root, query, cb) -> cb.isNull(root.get(field));
    }

    @SafeVarargs
    public static <T> Specification<T> and(Specification<T>... specifications){
        return (root, query, cb) -> cb.and(Arrays.stream(specifications).map(s -> s.toPredicate(root, query, cb)).toArray(Predicate[]::new));
    }

    @SafeVarargs
    public static <T> Specification<T> or(Specification<T>... specifications){
        return (root, query, cb) -> cb.or(Arrays.stream(specifications).map(s -> s.toPredicate(root, query, cb)).toArray(Predicate[]::new));
    }

    public static <T> Specification<T> asc(String field){
        return (root, query, cb) -> query.orderBy(cb.asc(root.get(field))).getRestriction();
    }

    public static <T> Specification<T> desc(String field){
        return (root, query, cb) -> query.orderBy(cb.desc(root.get(field))).getRestriction();
    }
}
