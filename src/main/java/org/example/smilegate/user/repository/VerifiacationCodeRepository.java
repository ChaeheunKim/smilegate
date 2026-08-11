package org.example.smilegate.user.repository;

import org.example.smilegate.user.domain.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifiacationCodeRepository extends JpaRepository<VerificationCode,Long> {
    VerificationCode findTopByEmailOrderByIdDesc(String email);
    @Modifying
    @Query("DELETE FROM VerificationCode vc WHERE vc.email = :email")
    int deleteAllByEmail(@Param("email") String email);
}
