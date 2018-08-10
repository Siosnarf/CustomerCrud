package com.solocal.customercrud.dao;

import java.util.List;
import com.solocal.customercrud.model.Customer;

public interface CustomerDao {

       /*
        * CREATE and UPDATE
        */
	   public void saveCustomer(Customer customer);
	   public void saveCustomers(List<Customer> customers);

       /*
        * READ
        */
       public List<Customer> listCustomers();
       public Customer getCustomer(Long id);

       /*
        * DELETE
        */
       public void deleteCustomer(Long id);
       public void deleteCustomers(List<Long> ids);
}

