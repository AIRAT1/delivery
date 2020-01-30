package io.delivery.controller;

import io.delivery.entity.Document;
import io.delivery.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    final private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentList() {
        return documentService.getDocumentList();
    }

    @RequestMapping(value = "/get/name/{name}")
    @ResponseBody
    public List<Document> getDocumentByName(@PathVariable(value = "name") String name) {
        return documentService.findByName(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Document addDocument(@RequestBody Document document) {
        documentService.create(document);
        return document;
    }
}