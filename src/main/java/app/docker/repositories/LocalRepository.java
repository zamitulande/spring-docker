package app.docker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.docker.entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer>{
    
}
