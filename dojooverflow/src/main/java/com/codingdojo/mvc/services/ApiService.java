package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.repositories.AnswerRepository;
import com.codingdojo.mvc.repositories.QuestionRepository;
import com.codingdojo.mvc.repositories.TagRepository;

@Service
public class ApiService {
	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	TagRepository tagRepository;

	@Autowired
	AnswerRepository answerRepository;

	public List<Question> allQuestions() {
		return questionRepository.findAll();
	}

	public Question findQuestionById(Long id) {
		Optional<Question> question = questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			return null;
		}
	}

	public Tag findTagById(Long id) {
		Optional<Tag> tag = tagRepository.findById(id);
		if (tag.isPresent()) {
			return tag.get();
		} else {
			return null;
		}
	}

	public Answer createAnswer(Answer newAnswer) {
		return answerRepository.save(newAnswer);

	}

	public Tag findTagBySubject(String subject) {
		Optional<Tag> tag = tagRepository.findBySubject(subject);
		if (tag.isPresent()) {
			return tag.get();
		} else {
			return null;
		}
	}

	public void saveTag(Tag tag) {
		tagRepository.save(tag);
	}

	public void saveQuestion(Question question) {
		questionRepository.save(question);
	}

}
