package pqk.project1.openapi.web.master.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pqk.project1.openapi.web.master.mapper.CustomerMapper;
import pqk.project1.openapi.web.master.pojo.Customer;
import pqk.project1.openapi.web.master.service.CustomerService;

import java.util.List;

//加上Service注解，目的：让spring-context扫包时扫到，同时spring-transaction.xml可以管理service中的事务
@Service//申明bean 且beanID == "customerServiceImpl"
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void insertCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        if(customer.getId()!=null){
            customerMapper.updateCustomer(customer);
        }else{
            //TODO 更新是根据id更新，所以需要传递id,如果没有传递，我们需要提示用户
        }
    }

    @Override
    public void deleteCustomerById(Long id) {
        if(id!=null){
            customerMapper.deleteCustomerById(id);
        } else{
            //TODO 更新是根据id更新，所以需要传递id,如果没有传递，我们需要提示用户
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        if (id != null) {
            return customerMapper.getCustomerById(id);
        } else {
            //TODO 更新是根据id更新，所以需要传递id,如果没有传递，我们需要提示用户
        }
    return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerMapper.getAllCustomers();
    }
}
