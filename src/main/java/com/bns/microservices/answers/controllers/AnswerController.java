package com.bns.microservices.answers.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bns.microservices.answers.models.entity.Answer;
import com.bns.microservices.answers.services.AnswerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AnswerController {

	private final AnswerService answerService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Iterable<Answer> answers){
		
		Iterable<Answer> answersDB = answerService.saveAll(answers);
		return ResponseEntity.status(HttpStatus.CREATED).body(answersDB);
	}
	
	@GetMapping("/student/{studentId}/exam/{examId}")
	public ResponseEntity<?> getAnswerByStudentAndByExam(@PathVariable("studentId") Long studentId, @PathVariable("examId") Long examId){
		Iterable<Answer> answersListDb = answerService.findAnswerByStudentAndByExam(studentId, examId);
		return ResponseEntity.ok(answersListDb);
	}
	
	@GetMapping("/student/{studentId}/exams-answered")
	public ResponseEntity<?> getAnswerIdWithAnswersByStudent(@PathVariable("studentId") Long studentId){
		Iterable<Long> answersIdListDb = answerService.findAnswerIdWithAnswersByStudent(studentId);
		return ResponseEntity.ok(answersIdListDb);
	}
}
