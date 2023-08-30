package risto.computer.shop.api.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import risto.computer.shop.api.util.Response;
import risto.computer.shop.api.customer.entity.Customer;
import risto.computer.shop.api.customer.service.CustomerService;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("customers")
    public Response saveCustomer(@RequestBody Customer theCustomer) {

        return customerService.save(theCustomer);
    }


    @GetMapping("customers")
    public Response getAllCustomers(@RequestParam(required = false) String name) {

        return customerService.allCustomers(name);
    }

    @PutMapping("customers")
    public Response updateCustomer(@RequestBody Customer theCustomer) {

        return customerService.save(theCustomer);
    }

    @DeleteMapping("customers/{customerId}")
    public Response deleteCustomer(@PathVariable Integer customerId) {

        return customerService.deleteCustomer(customerId);
    }
}