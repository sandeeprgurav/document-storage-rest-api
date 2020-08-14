DROP TABLE IF EXISTS documents;
 
CREATE TABLE documents (
  document_id VARCHAR(250) PRIMARY KEY,
  file_name VARCHAR(250) NOT NULL,
  size long NOT NULL,  
  content_type VARCHAR(250) DEFAULT NULL,  
  active_flag boolean NULL,
  file blob NOT NULL,
  created_date Date,  
  modified_date Date
);
