package app.docker.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import app.docker.entities.Local;
import app.docker.entities.Manager;
import app.docker.entities.NewOrders;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void saveOrder(){

        Manager manager = Manager.builder()
             .firstName("hermana")
             .lastName("iglesia")
             .build();

        Local local = Local.builder()
                        .name("salchipaperia")
                        .floor("first")
                        .manager(manager)
                        .build();

        
        NewOrders newOrders = NewOrders.builder()
                                .description("sandwinsh")
                                .price(10000)
                                .local(local)
                                .build();

            orderRepository.save(newOrders);
    }

    @Test
    public void findAllOrdersPaging(){
        Pageable firstPageableWirtThreeRecords = PageRequest.of(0, 2);
        List<NewOrders> ordersList = orderRepository.findAll(firstPageableWirtThreeRecords).getContent();
        long totalElements = orderRepository.findAll(firstPageableWirtThreeRecords).getTotalElements();
        long totalPages = orderRepository.findAll(firstPageableWirtThreeRecords).getTotalPages();

        System.out.println("total Elements "+totalElements);
        System.out.println("total pages "+ totalPages);
        System.out.println("order list "+ ordersList);
    }

    @Test
    public void findAllOrdersWithSorting(){
        Pageable sortByPrice = PageRequest.of(0, 3, Sort.by("price"));
        Pageable sortByPriceDesc = PageRequest.of(0, 3, Sort.by("price").descending());

        List<NewOrders> ordersList = orderRepository.findAll(sortByPriceDesc).getContent();

        System.out.println("Order list "+ ordersList);
    }

    @Test
    public void findAllOrderDescriptionContaining(){
        Pageable pageable = PageRequest.of(0, 5);
        List<NewOrders> ordersList = orderRepository.findByDescriptionContaining("as", pageable).getContent();
        System.out.println("order list "+ ordersList);
    }
}
