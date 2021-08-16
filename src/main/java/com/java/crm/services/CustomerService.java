package com.java.crm.services;


import com.java.crm.model.Customer;
import com.java.crm.repository.CustomerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Service
public class CustomerService  {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public List<Customer> getCustomer() {
        List<Customer> customersList = customerRepository.findAll();
        Collections.sort(customersList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });

        return customersList;
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        //customerRepository.save(customer);
        customerRepository.saveAndFlush(customer);

    }

    @Transactional
    public void updateCustomer(int Id) {
        Customer customer = customerRepository.getById(Id);
        customerRepository.save(customer);

    }
}
