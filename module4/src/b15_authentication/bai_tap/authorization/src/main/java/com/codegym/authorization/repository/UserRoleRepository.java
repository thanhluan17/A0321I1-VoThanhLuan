package com.codegym.authorization.repository;

import com.codegym.authorization.model.User;
import com.codegym.authorization.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByUser(User user);

    @Query("select ur.role.roleName from UserRole ur where ur.user.userId = :userId")
    List<String> findAllRoleByUser(Long userId);
}
