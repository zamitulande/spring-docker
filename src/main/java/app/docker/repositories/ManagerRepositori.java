package app.docker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.docker.entities.Manager;

@Repository
public interface ManagerRepositori extends JpaRepository<Manager, Integer>{
    
}
