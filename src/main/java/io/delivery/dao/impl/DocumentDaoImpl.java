package io.delivery.dao.impl;

import io.delivery.dao.DocumentDao;
import io.delivery.entity.Document;

public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao {
    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }


}
