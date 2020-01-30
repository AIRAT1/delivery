package io.delivery.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Basic methods for DAO
 */
public interface BasicDao<T> {
    /**
     * @return current hibernate session
     */
    Session getCurrentSession();

    /**
     * @return list for entities
     */
    List<T> getList();

    /**
     * Create entity at database
     * @param entity - current entity
     * @return created entity
     */
    T create(T entity);
}