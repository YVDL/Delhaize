package com.delhaize.services;

import com.delhaize.domain.Customer;
import com.delhaize.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    public CustomerRepository getCustomerRepository() {

        return customerRepository;
    }


}
