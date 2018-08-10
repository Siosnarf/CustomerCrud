package com.solocal.customercrud.dao.impl;

import java.util.List;

import com.solocal.customercrud.dao.CustomerDao;
import com.solocal.customercrud.model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

       @Autowired
       private SessionFactory sessionFactory;

       public void saveCustomer(Customer customer) {
              
              getSession().merge(customer);
       }
       
       public void saveCustomers(List<Customer> customers) {
           for(Customer customer : customers){
        	   getSession().merge(customer);
           }
       }

       public List<Customer> listCustomers() {

              return getSession().createCriteria(Customer.class).list();
       }

       public Customer getCustomer(Long id) {
              return (Customer) getSession().get(Customer.class, id);
       }

       public void deleteCustomer(Long id) {

              Customer customer = getCustomer(id);

              if (null != customer) {
                     getSession().delete(customer);
              }
       }

       public void deleteCustomers(List<Long> ids) {
    	   for(Long id : ids){
    		   deleteCustomer(id);    		   
    	   }
       }
       
       private Session getSession() {
              Session sess = getSessionFactory().getCurrentSession();
              if (sess == null) {
                     sess = getSessionFactory().openSession();
              }
              return sess;
       }

       private SessionFactory getSessionFactory() {
              return sessionFactory;
       }
}