package risto.computer.shop.api.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import risto.computer.shop.api.util.CustomError;
import risto.computer.shop.api.util.Response;
import risto.computer.shop.api.util.Validations;
import risto.computer.shop.api.customer.dao.CustomerRepository;
import risto.computer.shop.api.customer.entity.Customer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Response save(Customer customer) {

        if (Validations.isFiledEmpty(customer.getFirstName())) {
            return Response.error(CustomError.emptyFiledError("First name"));
        } else if (Validations.isFiledEmpty(customer.getLastName())) {
            return Response.error(CustomError.emptyFiledError("Last name"));
        } else if (Validations.isFiledEmpty(customer.getEmail())) {
            return Response.error(CustomError.emptyFiledError("Email"));
        } else if (Validations.isFiledEmpty(customer.getComputer().getName())) {
            return Response.error(CustomError.emptyFiledError("Computer name"));
        } else if (Validations.isFiledEmpty(customer.getComputer().getProcessor())) {
            return Response.error(CustomError.emptyFiledError("Computer processor"));
        } else if (Validations.isFiledEmpty(customer.getComputer().getInstalledRam())) {
            return Response.error(CustomError.emptyFiledError("Computer RAM"));
        } else
            return Response.success(customerRepository.save(customer));
    }

    public Response allCustomers(String name) {
        List<Customer> customers;

        if (Validations.isFiledEmpty(name)) {
            customers = customerRepository.findAll();
        } else {
            customers = customerRepository.findByFirstOrLastName(name);
        }

        if (customers.isEmpty()) {
            return Response.error(CustomError.noCustomers());
        } else
            return Response.success(customers);
    }

    public Response deleteCustomer(Integer customerId) {

        if (customerRepository.findById(customerId).isEmpty()) {
            return Response.error(CustomError.customerNotFound());
        } else {
            customerRepository.deleteById(customerId);
        }
        return Response.success("Customer with id " + customerId + " deleted.");
    }
}