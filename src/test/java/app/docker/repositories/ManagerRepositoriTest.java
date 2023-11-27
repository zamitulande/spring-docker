package app.docker.repositories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.docker.entities.Manager;

@SpringBootTest
public class ManagerRepositoriTest {

    @Autowired
    private ManagerRepositori managerRepositori;

    @Test
    public void findAllManager(){
        List<Manager> managersList = managerRepositori.findAll();
        System.out.println("managerList = "+managersList);
    }
}
