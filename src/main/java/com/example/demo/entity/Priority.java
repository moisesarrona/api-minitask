package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "priorities")
public class Priority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name cannot be empty")
	@Size(min = 1, max = 50, message = "Name length is 1 - 50")
	@Column(length = 50, unique = true, nullable = false)
	private String name;
	
	@NotEmpty(message = "Description cannot be empty")
	@Size(min = 1, max = 150, message = "Description length is 1 - 150")
	@Column(length = 150)
	private String description;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	@OneToMany(mappedBy = "priority", fetch = FetchType.LAZY)
	private List<Task> tasks = new ArrayList<>();
}
