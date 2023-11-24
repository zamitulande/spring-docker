package app.docker.repositories;

import app.docker.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer(){
        Customer customer = Customer.builder()
                        .firstName("Lina")
                        .lastName("Gaviria")
                        .email("fergar@correo.com")
                        .build();

         customerRepository.save(customer);
    }
}