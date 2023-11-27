package app.docker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.docker.entities.Local;

public interface LocalRepository extends JpaRepository<Local, Integer>{
    
}
