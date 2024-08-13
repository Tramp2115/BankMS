package com.lukas.loans.repository;

import com.lukas.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoansRepository extends JpaRepository <Loans, Long> {
    Optional<Loans> findByMobileNumber(String mobileNumber);
}
