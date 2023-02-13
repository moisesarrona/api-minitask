package com.moisesarrona.minitask.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 50, message = "Minimum 2 and Maximum 50 characters")
    @Column(length = 50, nullable = false, unique = true)
    private String name;

    private String description;

    private String observation;

    @NotNull(message = "dateStart is required")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @NotNull(message = "dateEnd is required")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_end", nullable = false)
    private Date dateEnd;

    @NotNull(message = "repetitive is required")
    @Column(nullable = false)
    private Boolean repetitive;

    @NotNull(message = "completed is required")
    @Column(nullable = false)
    private Boolean completed;

    @NotNull(message = "status is required")
    @Column(nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "phase_id")
    private Phase phase;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JoinTable(
            name = "task_tags",
            joinColumns = @JoinColumn(name = "task_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tag_id", nullable = false)
    )
    @ManyToMany
    private List<Tag> tags;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
}
