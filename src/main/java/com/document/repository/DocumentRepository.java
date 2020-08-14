package com.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.document.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	public Document findByDocumentId(String documentId);

	public void deleteByDocumentId(String documentId);
}
