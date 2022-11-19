package com.example.demo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDto {

    private final Integer id;
    private final String name;
    private final String email;
    private final LocalDateTime created;
    private final LocalDateTime updated;

    public UserDto(Integer id, String name, String email, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created = created;
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
