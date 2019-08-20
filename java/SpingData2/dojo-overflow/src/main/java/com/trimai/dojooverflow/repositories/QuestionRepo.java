package com.trimai.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trimai.dojooverflow.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {
	List<Question> findAll();
	
	@Query("SELECT q FROM Question q JOIN q.tags t GROUP BY q.id")
	List<Question> joinQuestionsAndTags();
}
