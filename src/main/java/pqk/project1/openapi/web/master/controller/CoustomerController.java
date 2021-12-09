package pqk.project1.openapi.web.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pqk.project1.openapi.web.master.pojo.Customer;
import pqk.project1.openapi.web.master.service.CustomerService;

@RestController
@RequestMapping("/sys/customer")
public class CoustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(Customer customer){
        customerService.insertCustomer(customer);
        return "success";
    }


}
