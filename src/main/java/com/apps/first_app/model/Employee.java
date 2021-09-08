package com.apps.first_app.model;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Basic(optional = false) // bu not null demekdir. Yeni id sutunu null ola bilmez.
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    // burada @JoinColumn ne ucun istifade olunub ve neye gore @OneToOne?
    // @JoinColumn(name="id")
    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @ToString.Exclude
    private Department department;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @ToString.Exclude
    private Work work;
}