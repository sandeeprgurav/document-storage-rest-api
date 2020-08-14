package com.document.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.document.entity.Document;
import com.document.repository.DocumentRepository;

@Service
@Transactional
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	DocumentRepository documentRepository;

	@Override
	public Document saveDocument(MultipartFile document) throws IOException {
		Document newDocument = new Document();
		UUID uuid = UUID.randomUUID();
		newDocument.setDocumentId(uuid.toString());
		newDocument.setFileName(document.getOriginalFilename());
		newDocument.setSize(document.getSize());
		newDocument.setContentType(document.getContentType());
		newDocument.setActiveFlag(true);
		newDocument.setFile(document.getBytes());
		newDocument.setCreatedDate(LocalDate.now());
		
		return documentRepository.save(newDocument);
	}

	@Override
	public Document findDocument(String documentId) {		
		return documentRepository.findByDocumentId(documentId);
	}

	@Override
	public Document updateDocument(String documentId, MultipartFile document) throws IOException {
		if(documentRepository.findByDocumentId(documentId) == null) {
			return null;
		}
		Document updateDocument = new Document();		
		updateDocument.setDocumentId(documentId);
		updateDocument.setFileName(document.getOriginalFilename());
		updateDocument.setSize(document.getSize());
		updateDocument.setContentType(document.getContentType());
		updateDocument.setActiveFlag(true);
		updateDocument.setFile(document.getBytes());
		updateDocument.setCreatedDate(LocalDate.now());
		
		return documentRepository.save(updateDocument);		
	}

	@Override
	public Document deleteDocument(String documentId) {
		Document document = documentRepository.findByDocumentId(documentId);
		if(document == null) {
			return null;
		}
		documentRepository.deleteByDocumentId(documentId);				
		return document;
	}

}

