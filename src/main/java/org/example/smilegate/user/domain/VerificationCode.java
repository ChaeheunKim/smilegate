package org.example.smilegate.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String email;
    String code;
    LocalDateTime validatetime;
    @Column(nullable = false)
    private boolean verified;

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(validatetime);
    }



}
