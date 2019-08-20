package com.trimai.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trimai.dojooverflow.models.Answer;
import com.trimai.dojooverflow.models.Question;
import com.trimai.dojooverflow.models.Tag;
import com.trimai.dojooverflow.services.AnswerService;
import com.trimai.dojooverflow.services.QuestionService;
import com.trimai.dojooverflow.services.TagService;

@Controller
public class HomeController {
	@Autowired
	private QuestionService qS;
	@Autowired
	private AnswerService aS;
	@Autowired
	private TagService tS;
	
	@GetMapping("/questions")
	public String index(Model model) {
		List<Question> table = qS.index();
		model.addAttribute("table", table);
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("Ques") Question question) {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions")
	public String createQues(@Valid @ModelAttribute("Ques") Question question, BindingResult result, @RequestParam("tag") List<String> tags, Model model) {	
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		}
		Question newQues = qS.createOrUpdate(question);
		if (tags.size() > 3) {
			String err = "Maximum tags allow are 3";
			model.addAttribute("tag", tags.toString().replace("[", "").replace("]", ""));
			model.addAttribute("tagErr", err);
			return "newQuestion.jsp";
		}
		tags.forEach(tagName -> {
			Tag foundTag = tS.findTag(tagName);
			if (foundTag == null ) {
				Tag tag = new Tag();
				tag.setSubject(tagName.trim());
				tag.getQuestions().add(newQues);
				newQues.getTags().add(tag);
				tS.createOrUpdateTag(tag);
			} else {
				foundTag.getQuestions().add(newQues);
				newQues.getTags().add(foundTag);
				tS.createOrUpdateTag(foundTag);
			}
		});
		
		return "redirect:/questions";
	}
	
	@GetMapping("/questions/{id}")
	public String answer(@PathVariable("id") Long id, @ModelAttribute("answerModel") Answer answer, Model model) {
		Question question = qS.findQuestion(id);
		List<Answer> answers = aS.getAnswers(id);
		model.addAttribute("answers", answers);
		model.addAttribute("question", question);
		return "answer.jsp";
	}
	
	@PostMapping("/questions/{id}")
	public String createAnswer(@Valid @ModelAttribute("answerModel") Answer answer, BindingResult result, @PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			Question question = qS.findQuestion(id);
			List<Answer> answers = aS.getAnswers(id);
			model.addAttribute("answers", answers);
			model.addAttribute("question", question);
			return "answer.jsp";
		}
		Answer newAns = new Answer();
		newAns.setAnswer(answer.getAnswer());
		newAns.setQuestion(answer.getQuestion());
		Answer ans = aS.createOrUpdate(newAns);
		return "redirect:/questions/" + id;
	}
}
