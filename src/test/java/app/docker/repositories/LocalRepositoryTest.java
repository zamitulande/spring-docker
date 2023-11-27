package app.docker.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.docker.entities.Local;
import app.docker.entities.Manager;
import app.docker.entities.NewOrders;

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
             .firstName("Logan")
             .lastName("x-men")
             .build();

        NewOrders newOrders = NewOrders.builder()
            .description("nevera")
            .price(60.5)
            .build();
        
        NewOrders newOrders2 = NewOrders.builder()
            .description("lavadora")
            .price(80.5)
            .build();

        Local local = Local.builder()
            .name("eletrodomesticos")
            .floor("second floor")
            .manager(manager)
            .newOrders(List.of(newOrders, newOrders2))
            .build();

        localRepository.save(local);
    }

    @Test
    public void findAllLocalswithOrders(){
        List<Local> locals = localRepository.findAll();
        System.out.println("localsList = "+locals);
    }
}
