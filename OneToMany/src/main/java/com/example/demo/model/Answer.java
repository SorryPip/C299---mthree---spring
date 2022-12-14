package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answer")
@Getter
@Setter
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	public Answer(String description, Question question) {
		this.description = description;
		this.question = question;
	}
}
