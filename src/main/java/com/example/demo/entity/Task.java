package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter name")
    @Size(min = 3, max= 50, message = "Minimum 3 wor Maximum 50")
    private String name;

    @Size(max = 255, message = "Maximum 255")
    @Column(length = 255)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priority_id", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private Priority priority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @ToString.Exclude
    private User user;

    @JoinTable(
            name = "task_tags",
            joinColumns = @JoinColumn(name = "task_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false)
    )

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Tag> tags;
}
