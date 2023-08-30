package risto.computer.shop.api.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import risto.computer.shop.api.customer.entity.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
}