package app.docker.repositories;

import app.docker.entities.Address;
import app.docker.entities.Customer;

import java.util.List;

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
                        .firstName("lina")
                        .lastName("capote")
                        .email("lina@correo.com")
                        .build();

         customerRepository.save(customer);
    }

    @Test
    public void saveCustomerWithAddressEmbedded(){
            Address address = Address.builder()
                        .mainStreet("carrera belen")
                        .secondaryStreet("licorera calle 3")
                        .city("Popayan")
                        .build();

             Customer customer = Customer.builder()
                        .firstName("lina")
                        .lastName("capote")
                        .email("lina@correo.com")
                        .address(address)
                        .build();

         customerRepository.save(customer);
    }

    @Test
    public void findCustomerByFirstName(){
        Customer customer = customerRepository.findByFirstName("Martin").get();
        System.out.println("customer ="+customer);
    }

    @Test
    public void findAllCustomer(){
        List<Customer> customerList = customerRepository.findAll();
        System.out.println("List customers ="+customerList);
    }

    @Test
    public void findAllCustomerFirstNameContaining(){
        List<Customer> customer = customerRepository.findByFirstNameContaining("Na");
        System.out.println("customersList = "+customer);
    }

    @Test void findAllCustomerByLastNameNotNull(){
        List<Customer> customersList = customerRepository.findByLastNameNotNull();
        System.out.println("customer list = "+customersList);
    }

    @Test
    public void findAllCustomerByAddressCity(){
        List<Customer> customersList = customerRepository.findByAddress_city("Cali");
        System.out.println("customerList = "+ customersList);
    }

    @Test
    public void getCustomerByEmailAddress(){
        Customer customer = customerRepository.getCustomerByEmailAddress("lina@correo.com");
        System.out.println("customer email = "+ customer);
    }

    @Test
    public void getCustomerFirstNameByEmailaAddress(){
        String firstName = customerRepository.getCustomerFirstNameByEmailAddress("zamit@correo.com");
        System.out.println("firstName = "+ firstName);
    }

    @Test
    public void getCustomerByEmailAddressNative(){
        Customer customer = customerRepository.getCustomerByEmailAddressNative("zamit@correo.com");
        System.out.println("consulta nativa = "+ customer);
    }

     @Test
    public void getCustomerByEmailAddressNativeWithParams(){
        Customer customer = customerRepository.getCustomerByEmailAddressNativeWithParams("zamit@correo.com");
        System.out.println("consulta nativa = "+ customer);
    }

    @Test
    public void updateCustomerNameByEmail(){
        customerRepository.updateCustomerNameByEmail("hulmar", "zamit@correo.com");
    }
}