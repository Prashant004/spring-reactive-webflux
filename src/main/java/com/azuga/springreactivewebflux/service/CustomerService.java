package com.azuga.springreactivewebflux.service;

import com.azuga.springreactivewebflux.dao.CustomerDao;
import com.azuga.springreactivewebflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("Total execution Time : " + (end - start));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomerStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution Time : " + (end - start));
        return customers;
    }
}
