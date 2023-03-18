package com.example.personms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@JsonIgnoreProperties
        ({"hibernateLazyInitializer", "handler"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 15, unique = true, nullable = false)
    private String username;

    @Column(name = "password", length = 16, nullable = false)
    private String password;

    @Column(name = "number", length = 20, unique = true)
    private String number;

    @Column(name = "app_pin", length = 4, nullable = false)
    private String appPin;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;


    @OneToOne(targetEntity = PersonEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "person_user",
            joinColumns = @JoinColumn(name = "user_id", unique = true),
            inverseJoinColumns = @JoinColumn(name = "person_id", unique = true))
    private PersonEntity person;
}
