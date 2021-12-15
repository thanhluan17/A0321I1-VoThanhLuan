package com.codegym.phone.repository;

import com.codegym.phone.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone, Integer> {
}
