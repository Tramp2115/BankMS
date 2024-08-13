package com.lukas.accounts.service.impl;

import com.lukas.accounts.dto.AccountsDto;
import com.lukas.accounts.dto.CardsDto;
import com.lukas.accounts.dto.CustomerDetailsDto;
import com.lukas.accounts.dto.LoansDto;
import com.lukas.accounts.entity.Accounts;
import com.lukas.accounts.entity.Customer;
import com.lukas.accounts.exception.ResourceNotFoundException;
import com.lukas.accounts.mapper.AccountsMapper;
import com.lukas.accounts.mapper.CustomerMapper;
import com.lukas.accounts.repository.AccountsRepository;
import com.lukas.accounts.repository.CustomerRepository;
import com.lukas.accounts.service.ICustomerService;
import com.lukas.accounts.service.client.CardsFeignClient;
import com.lukas.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()->new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());


        return customerDetailsDto;
    }
}
