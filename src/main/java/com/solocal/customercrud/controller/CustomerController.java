package com.solocal.customercrud.controller;

import java.util.Map;

import com.solocal.customercrud.model.Customer;
import com.solocal.customercrud.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {

       @Autowired
       private CustomerService customerService;

       @RequestMapping(value = { "/", "/listCustomers" })
       public String listCustomers(Map<String, Object> map) {

              map.put("customer", new Customer());

              map.put("customerList", customerService.listCustomers());

              return "/customer/listCustomers";
       }

       @RequestMapping("/get/{customerId}")
       public String getCustomer(@PathVariable Long customerId, Map<String, Object> map) {

              Customer customer = customerService.getCustomer(customerId);

              map.put("customer", customer);

              return "/customer/customerForm";
       }

       @RequestMapping(value = "/save", method = RequestMethod.POST)
       public String saveCustomer(@ModelAttribute("customer") Customer customer,
                     BindingResult result) {

              customerService.saveCustomer(customer);
              
              return "redirect:listCustomers";
       }

       @RequestMapping("/delete/{customerId}")
       public String deleteCustomer(@PathVariable("customerId") Long id) {

              customerService.deleteCustomer(id);
              
              return "redirect:/customer/listCustomers";
       }
}