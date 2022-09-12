package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

@SpringBootApplication
public class OneToManyApplication {

	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(OneToManyApplication.class, args);
		System.out.println("one to many app");
		
		// Testing
		QuestionRepository questionRepo = configurableApplicationContext.getBean(QuestionRepository.class);
		
		Question question = new Question("How to use spring?");
		Answer answer_one = new Answer("Kill yourself", question);
		Answer answer_two = new Answer("Just die", question);
		question.getAnswers().add(answer_one);
		question.getAnswers().add(answer_two);
		questionRepo.save(question);
		
		Question question_two = new Question("Will I get a job");
		Answer answer_three = new Answer("bhahaha fuck no", question_two);
		Answer answer_four = new Answer("who da faq would want to hire you?", question_two);
		question_two.getAnswers().add(answer_three);
		question_two.getAnswers().add(answer_four);
		questionRepo.save(question_two);
		
	}

}
