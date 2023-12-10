package com.eazybytes.loans.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.eazybytes.loans.constants.LoansConstants;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.entity.LoansRepository;
import com.eazybytes.loans.exception.LoanAlreadyExistsException;
import com.eazybytes.loans.service.ILoansService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        loansRepository.save(createNewLoan(mobileNumber));
    }


    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_HOME_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_HOME_LOAN_LIMIT);
        newLoan.setCreatedAt(LocalDateTime.now());
        newLoan.setCreatedBy("Anonymous");
        return newLoan;

    }
    
}
