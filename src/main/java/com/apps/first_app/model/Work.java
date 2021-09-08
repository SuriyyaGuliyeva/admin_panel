package com.apps.first_app.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="works")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name="work_id")
    @ToString.Exclude
    private List<Employee> employees;
}
