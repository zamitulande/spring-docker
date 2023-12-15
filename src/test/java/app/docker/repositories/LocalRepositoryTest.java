package app.docker.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.docker.entities.Address;
import app.docker.entities.Customer;
import app.docker.entities.Local;
import app.docker.entities.Manager;
//import app.docker.entities.NewOrders;

@SpringBootTest
public class LocalRepositoryTest {

    @Autowired
    private LocalRepository localRepository;

    @Test
    public void saveLocal(){

        Manager manager = Manager.builder()
             .firstName("Logan")
             .lastName("x-men")
             .build();

        Local local = Local.builder()
            .name("PetShop")
            .floor("second Floor")
            .manager(manager)
            .build();

      localRepository.save(local);
    }

    @Test
    public void findAllLocals(){
        List<Local> localsList = localRepository.findAll();
        System.out.println("locales = "+localsList);
    }

    @Test
    public void saveLocalwithOrders(){

         Manager manager = Manager.builder()
             .firstName("yugi")
             .lastName("oh")
             .build();

        // NewOrders newOrders = NewOrders.builder()
        //     .description("cartas")
        //     .price(10.5)
        //     .build();
        
        // NewOrders newOrders2 = NewOrders.builder()
        //     .description("dragon")
        //     .price(250.5)
        //     .build();

        Local local = Local.builder()
            .name("japon")
            .floor("second floor")
            .manager(manager)
            //.newOrders(List.of(newOrders, newOrders2))
            .build();

        localRepository.save(local);
    }

    @Test
    public void findAllLocalswithOrders(){
        List<Local> locals = localRepository.findAll();
        System.out.println("localsList = "+locals);
    }

    @Test
    public void saveLocalWithCustomer(){

        Manager manager = Manager.builder()
             .firstName("yugi")
             .lastName("oh")
             .build();

        Address address = Address.builder()
                        .mainStreet("carrera belen")
                        .secondaryStreet("licorera calle 3")
                        .city("Popayan")
                        .build();

        Customer customer = Customer.builder()
                            .firstName("mario")
                            .lastName("cimarro")
                            .email("correod2@corre.com")
                            .address(address)
                            .build();

        Customer customer2 = Customer.builder()
                            .firstName("edie")
                            .lastName("polasqui")
                            .email("edide@corre.com")
                            .address(address)
                            .build();

        Local local = Local.builder()
                        .name("bell")
                        .floor("second")
                        .customersList(List.of(customer, customer2))
                        .manager(manager)
                        .build();

            localRepository.save(local);
    }
}
