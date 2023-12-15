package app.docker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.docker.entities.NewOrders;

@Repository
public interface OrderRepository  extends JpaRepository<NewOrders, Integer>{
    
}
