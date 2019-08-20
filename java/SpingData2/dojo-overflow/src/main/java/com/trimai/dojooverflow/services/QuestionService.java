package com.trimai.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.dojooverflow.models.Question;
import com.trimai.dojooverflow.repositories.QuestionRepo;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepo qR;
	
	public Question createOrUpdate(Question question) {
		return qR.save(question);
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> question = qR.findById(id);
		if (question.isPresent()) {
			return question.get();
		}
		return null;
	}
	
	public List<Question> index() {
		return  qR.joinQuestionsAndTags();
	}
}
