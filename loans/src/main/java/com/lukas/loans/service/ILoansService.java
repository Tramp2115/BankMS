package com.lukas.loans.service;

import com.lukas.loans.dto.LoansDto;

public interface ILoansService {

    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoanDetails(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);

}
