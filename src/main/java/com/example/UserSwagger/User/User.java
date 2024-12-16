package com.example.UserSwagger.User;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Data
@Entity
@Table(name = "userSwagger", indexes = {
        @Index(name = "emailIndex",columnList = "email",unique = true)
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String name;
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    @Column(nullable = false)
    private String password;

    public String getName(){
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
