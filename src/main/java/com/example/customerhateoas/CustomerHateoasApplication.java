package com.example.customerhateoas;

import com.example.customerhateoas.dao.AddressDao;
import com.example.customerhateoas.dao.CustomerDao;
import com.example.customerhateoas.ds.Address;
import com.example.customerhateoas.ds.Customer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class CustomerHateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerHateoasApplication.class, args);
    }

    private final CustomerDao customerDao;
    private final AddressDao addressDao;

    public CustomerHateoasApplication(CustomerDao customerDao, AddressDao addressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
    }

    @Bean
    @Transactional
    public ApplicationRunner runner(){
        return r->{
            Customer customer1= new Customer("TH","Thomas","Hardy","thomas@gmail.com");
            Customer customer2= new Customer("TW","Thomas","Witch","witch@gmail.com");

            Address address1= new Address("11","Park Venue","Yangon","123");
            Address address2= new Address("12","Insein","Gof","223");
            Address address3= new Address("13","Adin","Lod","969");
            Address address4= new Address("14","Mordor","Kindoom","376");
            customer1.addAddress(address1);
            customer1.addAddress(address2);
            customer2.addAddress(address3);
            customer2.addAddress(address4);

            customerDao.save(customer1);
            customerDao.save(customer2);
        };
    }
}
