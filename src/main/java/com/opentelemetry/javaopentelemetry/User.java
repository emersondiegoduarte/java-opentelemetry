package com.opentelemetry.javaopentelemetry;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(schema = "public", name = "user")
public class User {

    @Id
    private Long id;
    private String username;
    private String name;
}
