package com.codegym.furama.repository;

import com.codegym.furama.model.User;
import com.codegym.furama.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByUser(User user);

    @Query("select ur.role.roleName from UserRole ur where ur.user.username = :username")
    List<String> findAllRoleByUser(String username);
}
