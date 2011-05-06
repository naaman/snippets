package com.force.sample.snippets.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Snippet {
	
	public enum SnippetType {
		Apex,
		Java,
		SOQL,
		JPQL
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	String id;
	String name;
	String body;
	@Enumerated(EnumType.STRING)
	SnippetType type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public SnippetType getType() {
		return type;
	}
	public void setType(SnippetType type) {
		this.type = type;
	}
	
}
