package com.document.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name = "documents")
@Entity
public class Document extends BaseEntity {

	@Id	
	@Column(name = "document_id")
	private String documentId;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "size")
	private Long size;

	@Column(name = "content_type")
	private String contentType;
	
	@Lob
	@Column(name = "file")
	private byte[] file;

	public Document() {

	}
	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", fileName=" + fileName + ", size=" + size + ", contentType="
				+ contentType + ", file=" + Arrays.toString(file) + "]";
	}

}
