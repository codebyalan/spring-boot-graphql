package com.ambro.spring.graphql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publicationId;
    private String name;
    private String location;

    @OneToMany(mappedBy = "publication")
    private Set<Book> books;

}
