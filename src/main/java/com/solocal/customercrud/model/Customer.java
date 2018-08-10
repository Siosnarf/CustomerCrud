package com.solocal.customercrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

       private Long id;
       private String name;
       private Integer phone;
       private String website;

       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       public Long getId() {
              return id;
       }

       @Column(nullable = false)
       public String getName() {
              return name;
       }

       @Column(nullable = false)
       public Integer getPhone() {
              return phone;
       }

       @Column
       public String getWebsite() {
              return website;
       }

		public void setId(Long id) {
			this.id = id;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public void setPhone(Integer phone) {
			this.phone = phone;
		}
	
		public void setWebsite(String website) {
			this.website = website;
		}
}