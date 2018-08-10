package com.solocal.customercrud.service.impl;

import java.util.List;

import com.solocal.customercrud.dao.CustomerDao;
import com.solocal.customercrud.model.Customer;
import com.solocal.customercrud.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

       @Autowired
       private CustomerDao customerDao;

       @Transactional
       public void saveCustomer(Customer customer) {
              customerDao.saveCustomer(customer);
       }
       
       @Transactional
       public void saveCustomers(List<Customer> customers) {
           customerDao.saveCustomers(customers);
       }

       @Transactional( readOnly = true)
       public List<Customer> listCustomers() {
              return customerDao.listCustomers();
       }

       @Transactional( readOnly = true)
       public Customer getCustomer(Long id) {
              return customerDao.getCustomer(id);
       }

       @Transactional
       public void deleteCustomer(Long id) {
              customerDao.deleteCustomer(id);

       }
       @Transactional
       public void deleteCustomers(List<Long> ids) {
              customerDao.deleteCustomers(ids); 

       }
}
