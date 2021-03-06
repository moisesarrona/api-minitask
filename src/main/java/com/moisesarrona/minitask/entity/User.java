package com.moisesarrona.minitask.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author moisesarrona
 * @version 0.1
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter your name")
    @Size(min = 3, max = 50, message = "Minimum 3 wor Maximum 50")
    @Column(length = 50, nullable = false)
    private String name;

    @NotEmpty(message = "Enter your lastname")
    @Size(min = 3, max = 50, message = "Minimum 3 wor Maximum 50")
    @Column(length = 50, nullable = false)
    private String lastname;

    @NotEmpty(message = "Enter your username")
    @Size(min = 3, max = 50, message = "Minimum 3 wor Maximum 50")
    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Enter your email")
    @Size(min = 8, max = 150, message = "Minimum 10 wor Maximum 150")
    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Size(min = 10, max = 150, message = "Minimum 10 wor Maximum 150")
    @Column(length = 150)
    private String phone;

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
