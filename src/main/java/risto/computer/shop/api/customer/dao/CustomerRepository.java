package risto.computer.shop.api.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import risto.computer.shop.api.customer.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where lower(c.firstName) like lower(concat('%', :name,'%'))" +
            "or lower(c.lastName) like lower(concat('%', :name,'%')) ")
    List<Customer> findByFirstOrLastName(@Param("name") String name);
}