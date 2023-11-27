package app.docker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.docker.entities.Manager;

public interface ManagerRepositori extends JpaRepository<Manager, Integer>{
    
}
