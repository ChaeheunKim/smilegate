package org.example.smilegate.user.repository;

import lombok.NoArgsConstructor;
import org.example.smilegate.user.domain.User;
import org.hibernate.query.criteria.JpaCoalesce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);
    User findByEmail(String email);
}
