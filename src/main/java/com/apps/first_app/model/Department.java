package com.apps.first_app.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    // burada @OrderColumn nedir ve type nedir?
    @OneToMany(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="department_id")
//    @OrderColumn(name="type")
    @ToString.Exclude
    private List<Employee> employees;
}
