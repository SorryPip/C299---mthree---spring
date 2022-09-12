package com.example.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Question;

@RestController
public class AppController {
	
	@Autowired
	private QuestionServiceImplementaion implementation;
	
	@GetMapping("/showAll")
	public List<Question> showAll(){
		return implementation.getQuestions();
	}
}
