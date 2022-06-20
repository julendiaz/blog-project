package com.julentech.blogproject;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstname;
    @Column(name = "lastname", nullable = true)
    private String lastName;
}
