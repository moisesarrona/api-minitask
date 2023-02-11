package com.moisesarrona.minitask.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author moisesarrona
 * @version 0.0.2
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    @Size(min = 2, max = 50, message = "Minimum 2 and Maximum 50 characters")
    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @NotBlank(message = "lastname is required")
    @Size(min = 2, max = 50, message = "Minimum 2 and Maximum 150 characters")
    @Column(length = 150, nullable = false)
    private String lastname;

    @NotNull(message = "birthday is required")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotBlank(message = "username is required")
    @Size(min = 2, max = 20, message = "Minimum 2 and Maximum 20 characters")
    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Size(min = 2, max = 255, message = "Minimum 2 and Maximum 255 characters")
    private String image;

    private String description;

    @Size(min = 2, max = 15, message = "Minimum 2 and Maximum 15 characters")
    @Column(length = 15)
    private String phone;

    @Size(min = 2, max = 50, message = "Minimum 2 and Maximum 50 characters")
    @Column(length = 50)
    private String link;

    @Email(message = "email is invalid",
            regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    @NotBlank(message = "email is required")
    @Size(min = 2, max = 150, message = "Minimum 2 and Maximum 150 characters")
    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 5, max = 255, message = "Minimum 2 and Maximum 250 characters")
    @Column(nullable = false)
    private String password;

    /*@NotNull(message = "status is required")
    @Column(nullable = false)*/
    private Boolean status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
