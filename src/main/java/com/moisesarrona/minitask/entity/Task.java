package com.moisesarrona.minitask.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
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
    @Column(length = 50, nullable = false)
    private String name;

    @Size(max = 255, message = "Maximum 255")
    @Column(length = 255)
    private String description;

    @NotNull(message = "Mode is required")
    @Column(nullable = false, columnDefinition = "BIT")
    private Boolean mode;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "status_id")
    //@ToString.Exclude
    private Status status;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "priority_id")
    //@ToString.Exclude
    private Priority priority;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "user_id")
    //@ToString.Exclude
    private User user;

    @JoinTable(
            name = "task_tags",
            joinColumns = @JoinColumn(name = "task_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false)
    )

    @ManyToMany(cascade = {})
    //@JsonManagedReference
    @ToString.Exclude
    private List<Tag> tags;
}
