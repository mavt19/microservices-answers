package com.bns.microservices.answers.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bns.microservices.answers.models.entity.Answer;

public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long>{

	@Query("select a from Answer a join fetch a.student s join fetch a.question q join fetch q.exam e where s.id = ?1 and e.id = ?2")
//	@Query("SELECT * FROM answers JOIN students ON answers.student_id = students.id JOIN questions ON answers.question_id = questions.id JOIN exams  ON questions.exam_id = exams.id  WHERE students.id = ?1 and exams.id = ?2")
	public Iterable<Answer> findAnswerByStudentAndByExam(Long studentId, Long examId); 
	
	@Query("select a.id from Answer a join a.student s join a.question q join q.exam e where s.id = ?1 group by a.id")
	public Iterable<Long> findAnswerIdWithAnswersByStudent(Long studentId); 
}
