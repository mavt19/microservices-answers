package com.bns.microservices.answers.services.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bns.microservices.answers.models.entity.Answer;
import com.bns.microservices.answers.models.repository.AnswerRepository;
import com.bns.microservices.answers.services.AnswerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService{

	private final AnswerRepository answerRepository;
	
	@Override
	@Transactional
	public Iterable<Answer> saveAll(Iterable<Answer> answers) {
		// TODO Auto-generated method stub
		return answerRepository.saveAll(answers);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Answer> findAnswerByStudentAndByExam(Long studentId, Long examId) {
		// TODO Auto-generated method stub
		return answerRepository.findAnswerByStudentAndByExam(studentId, examId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findAnswerIdWithAnswersByStudent(Long studentId) {
		// TODO Auto-generated method stub
		return answerRepository.findAnswerIdWithAnswersByStudent(studentId);
	}

}
