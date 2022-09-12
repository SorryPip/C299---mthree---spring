package com.example.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionServiceImplementaion {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public void createQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public void addAnswer(Long questionId, Answer answer) {
		Question question = questionRepository.findById(questionId).get();
		question.getAnswers().add(answer);
	}
	
	public List<Question> getQuestions(){
		return (List<Question>) questionRepository.findAll();
	}
}
