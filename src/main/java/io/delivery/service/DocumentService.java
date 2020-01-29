package io.delivery.service;

import io.delivery.entity.Document;

import java.util.List;

public interface DocumentService {
    /**
     * Receive all documents from db
     * @return document list
     */
    List<Document> getDocumentList();
}
