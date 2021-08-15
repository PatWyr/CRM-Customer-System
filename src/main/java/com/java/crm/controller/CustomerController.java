package com.java.crm.controller;

import com.java.crm.model.Customer;
import com.java.crm.repository.CustomerRepository;
import com.java.crm.services.CustomerService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> list = customerService.getCustomer();
       theModel.addAttribute("customers",list);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Customer customer = new Customer();
        theModel.addAttribute("customer",customer);
        return "add-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        System.out.println("Siemka");
        return "redirect:/customer/list";
    }
}
