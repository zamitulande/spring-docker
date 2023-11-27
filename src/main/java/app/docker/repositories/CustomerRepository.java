package app.docker.repositories;

import app.docker.entities.Customer;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameContaining(String firstName);

    List<Customer> findByLastNameNotNull();

    List<Customer> findByAddress_city(String city);


    @Query("select c from Customer c where c.email =?1")
    Customer getCustomerByEmailAddress(String email);

    @Query("select c.firstName from Customer c where c.email = ?1")
    String getCustomerFirstNameByEmailAddress(String email);

    @Query(
        value = "select * from customer where email =?1",
        nativeQuery = true
    )
    Customer getCustomerByEmailAddressNative(String email);

    @Query(
        value = "select * from customer where email = :email",
        nativeQuery = true
    )
    Customer getCustomerByEmailAddressNativeWithParams(@Param("email") String email);

    @Transactional
    @Modifying
    @Query(
        value = "update customer set first_name =?1 where email =?2",
        nativeQuery = true
    )
    void updateCustomerNameByEmail(String name, String email);
}
