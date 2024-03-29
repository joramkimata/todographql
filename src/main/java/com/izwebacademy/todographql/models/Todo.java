package com.izwebacademy.todographql.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.izwebacademy.todographql.enums.TodoStatus;
import com.izwebacademy.todographql.utils.BaseEntity;
import com.izwebacademy.todographql.utils.LocalDateAttributeConverter;

@Entity
@Table(name = "graphql_todos")
public class Todo extends BaseEntity {

	@Id
	@SequenceGenerator(name = "graphl_todos_seq", sequenceName = "graphl_todos_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "graphl_todos_seq")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(name = "start_date")
	private LocalDate startDate;

	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(name = "end_date")
	private LocalDate endDate;

	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(name = "completed_date")
	private LocalDate completedDate;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private TodoStatus status = TodoStatus.CREATED;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User createdBy;

	private Boolean completed = false;

	public Todo() {
	}

	public Todo(String title, String description, LocalDate startDate, LocalDate endDate, Category category, User createdBy) {
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(LocalDate completedDate) {
		this.completedDate = completedDate;
	}

	public TodoStatus getStatus() {
		return status;
	}

	public void setStatus(TodoStatus status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
