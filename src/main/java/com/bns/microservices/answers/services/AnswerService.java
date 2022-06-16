package com.bns.microservices.answers.services;

import com.bns.microservices.answers.models.entity.Answer;

public interface AnswerService {

	public Iterable<Answer> saveAll(Iterable<Answer> answers);
	
	public Iterable<Answer> findAnswerByStudentAndByExam(Long studentId, Long examId); 
	
	public Iterable<Long> findAnswerIdWithAnswersByStudent(Long studentId); 
}
