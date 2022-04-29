package com.mbavellar.springbootmongodb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mbavellar.springbootmongodb.dto.AuthorDTO;

@Document(collection = "comments")
public class Comment implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  private String id;
  private Date date;
  private String text;
  
  private AuthorDTO author;
  
  public Comment() {}

  public Comment(String id, Date date, String text, AuthorDTO author) {
    super();
    this.id = id;
    this.date = date;
    this.text = text;
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public AuthorDTO getAuthor() {
    return author;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Comment other = (Comment) obj;
    return Objects.equals(id, other.id);
  }
}