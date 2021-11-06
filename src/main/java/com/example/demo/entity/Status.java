package com.example.demo.entity;

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

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50, message = "The length of the name is 1 - 50")
    @NotEmpty(message = "The name must not be empty")
    @Column(length = 50, unique = true, nullable = false)
    private String name;

    @Size(min = 1, max = 50, message = "The length of the description is 1 - 50")
    @NotEmpty(message = "The description must not be empty")
    @Column(length = 150)
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();
}
