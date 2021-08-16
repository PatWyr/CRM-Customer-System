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
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int Id, Model theModel) {
        Customer customer = customerService.getCustomerRepository().getById(Id);
        theModel.addAttribute("customer",customer);
        customerService.updateCustomer(Id);
        return "add-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int Id, Model theModel) {
        Customer customer = customerService.getCustomerRepository().findById(Id).get();
        customerService.getCustomerRepository().delete(customer);
        return "redirect:/customer/list";
    }
}
