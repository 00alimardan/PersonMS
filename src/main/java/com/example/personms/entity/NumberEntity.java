package com.example.personms.entity;

import com.example.personms.model.Operator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "number")
public class NumberEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 4)
    private String code;

    @Column(name = "prefiks", length = 3)
    private String prefiks;

    @Column(name = "number", length = 9)
    private String number;

    @Column(name = "operator", length = 10)
    @Enumerated(EnumType.STRING)
    private Operator operator;
}
