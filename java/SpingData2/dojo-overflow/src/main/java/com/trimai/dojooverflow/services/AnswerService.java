package com.trimai.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.dojooverflow.models.Answer;
import com.trimai.dojooverflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepo aR;
	
	public Answer createOrUpdate(Answer answer) {
		return aR.save(answer);
	}
	
	public List<Answer> getAnswers(Long id) {
		return aR.findAllByQuestionId(id);
	}
}
