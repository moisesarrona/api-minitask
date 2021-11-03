package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The name cannot be empty")
    @Size(min = 1, max = 50, message = "The length of the name is 1 - 50")
    @Column(length = 50, unique = true, nullable = false)
    private String name;

    @NotEmpty(message = "The description cannot be empty")
    @Size(min = 1, max = 150, message = "The length of the description is 1 - 50")
    @Column(length = 150, unique = true)
    private String description;

    @NotNull(message = "The status cannot be empty")
    @Column(nullable = false)
    private Boolean status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}
