package com.bea.springbootmysql.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class Member {

    @Id
    private Long id;
    private String name;
    private String address;
    private Grade grade;
}
