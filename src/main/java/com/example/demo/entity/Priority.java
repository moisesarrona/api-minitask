package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "priorities")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotEmpty(message = "Enter name")
    @Size(min = 3, max = 50, message = "Minimum 3 wor Maximum 50")
    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Size(max = 255, message = "Maximum 255")
    @Column(length = 255)
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
}
