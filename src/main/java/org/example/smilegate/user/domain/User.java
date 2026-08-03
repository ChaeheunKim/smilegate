package org.example.smilegate.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.smilegate.user.dto.UserDTO;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String password;
    UserRole role;


    public User(UserDTO.UserSignupRequest request){
        this.username=request.getUsername();
        this.email=request.getEmail();
        this.password=request.getPassword();
        this.role=UserRole.USER;

    }
}
