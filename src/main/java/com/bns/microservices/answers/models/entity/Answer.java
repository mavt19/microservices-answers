package com.bns.microservices.answers.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "answers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String text;
	@ManyToOne(fetch = FetchType.LAZY)
	private Student student;
	@OneToOne(fetch = FetchType.LAZY)
	private Question question;
}
