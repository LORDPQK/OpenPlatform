package pqk.project1.openapi.web.master.mapper;

import pqk.project1.openapi.web.master.pojo.Customer;

import java.util.List;

public interface CustomerMapper {

    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);

    Customer getCustomerById(Long id);

    //查询所有的客户
    List<Customer> getAllCustomers();
}
