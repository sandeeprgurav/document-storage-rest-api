package com.document.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.document.entity.Document;
import com.document.service.IDocumentService;

@CrossOrigin
@RestController
@RequestMapping(value = "/storage")
public class DocumentController {
	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	private IDocumentService documentService;
			
	@PostMapping(value = "/documents")
	public ResponseEntity<Document> postDocuments(@RequestParam MultipartFile document) throws IOException {
		logger.info("Post Document method called");
		Document savedDocument = documentService.saveDocument(document);
		
		if(savedDocument != null) {
			return new ResponseEntity<Document>(savedDocument, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/documents/{documentId}")
	public ResponseEntity<Resource> getDocuments(@PathVariable String documentId) throws IOException {
		logger.info("Get Document method called");
		Document document = documentService.findDocument(documentId);
					
		if(document != null) {
			HttpHeaders header = new HttpHeaders();
	        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+document.getFileName());
	        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        header.add("Pragma", "no-cache");
	        header.add("Expires", "0");
			ByteArrayResource resource = new ByteArrayResource(document.getFile());
			return ResponseEntity.ok()
	                .headers(header)
	                .contentLength(document.getSize())
	                .contentType(MediaType.parseMediaType("application/octet-stream"))
	                .body(resource);
		} else {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/documents/{id}")
	public ResponseEntity<Document> updateDocuments(@RequestParam MultipartFile document, @PathVariable("id") String documentId) throws IOException {
		logger.info("Update Document method called");
		Document updatedDocument = documentService.updateDocument(documentId, document);
		
		if(updatedDocument != null) {
			return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/documents/{deleteDocumentId}")
	public ResponseEntity<Document> deleteDocuments(@PathVariable("deleteDocumentId") String documentId) throws IOException {
		logger.info("Update Document method called");
		Document deletedDocument = documentService.deleteDocument(documentId);
		
		if(deletedDocument != null) {
			return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Document>(HttpStatus.NOT_FOUND);
		}
	}
	
	
			
}

