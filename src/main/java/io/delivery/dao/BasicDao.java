package io.delivery.dao;

import io.delivery.entity.Document;
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

    /**
     * @param entity - document for update
     * @return entity
     */
    T update(T entity);

    /**
     * @param entity - document for delete
     * @return entity
     */
    T delete(T entity);

    /**
     * @param id - document id
     * @return entity
     */
    T findById(long id);
}
