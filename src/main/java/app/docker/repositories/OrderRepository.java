package app.docker.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.docker.entities.NewOrders;

@Repository
public interface OrderRepository  extends JpaRepository<NewOrders, Integer>{
    
    Page<NewOrders> findByDescriptionContaining(String description, Pageable pageable);
}
