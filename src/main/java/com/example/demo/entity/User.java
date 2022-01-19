package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter your name")
    @Size(min = 5, max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @NotEmpty(message = "Enter your lastname")
    @Size(min = 5, max = 50)
    @Column(length = 50, nullable = false)
    private String lastname;

    @NotEmpty(message = "Enter your email")
    @Size(min = 10, max = 150)
    @Column(length = 150, nullable = false)
    private String email;

    @Size(min = 10, max = 150)
    @Column(length = 150)
    private String phone;

    @Size(min = 10, max = 255)
    @Column(length = 255)
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
}
