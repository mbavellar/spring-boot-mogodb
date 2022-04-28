package com.mbavellar.springbootmongodb.services.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Long timestamp;
  private Integer status;
  private String errorString;
  private String messageString;
  private String path;
  
  public StandardError() {}

  public StandardError(Long timestamp, Integer status, String errorString, String messageString, String path) {
    super();
    this.timestamp = timestamp;
    this.status = status;
    this.errorString = errorString;
    this.messageString = messageString;
    this.path = path;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getErrorString() {
    return errorString;
  }

  public void setErrorString(String errorString) {
    this.errorString = errorString;
  }

  public String getMessageString() {
    return messageString;
  }

  public void setMessageString(String messageString) {
    this.messageString = messageString;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}