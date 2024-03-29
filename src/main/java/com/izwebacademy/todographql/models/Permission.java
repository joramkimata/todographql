package com.izwebacademy.todographql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.izwebacademy.todographql.utils.BaseEntity;

@Entity
@Table(name = "graphql_permissions")
public class Permission extends BaseEntity {

	@Id
	@SequenceGenerator(name = "graphql_permissions_seq", sequenceName = "graphql_permissions_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "graphql_permissions_seq")
	private Long id;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
