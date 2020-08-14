package com.document.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.document.entity.Document;

public interface IDocumentService {

	Document saveDocument(MultipartFile document) throws IOException;

	Document findDocument(String documentId);

	Document updateDocument(String documentId, MultipartFile document) throws IOException;

	Document deleteDocument(String documentId);
	
	
}
