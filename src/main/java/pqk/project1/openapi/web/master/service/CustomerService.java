package pqk.project1.openapi.web.master.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import pqk.project1.openapi.web.master.pojo.Customer;

import java.util.List;

public interface CustomerService {
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Long id);

    /**
     * 根据ids删除多用户
     * @param ids
     */
    void deleteCustomerByIds(long[] ids);

    Customer getCustomerById(Long id);

    //查询所有的客户
    List<Customer> getAllCustomers();

    PageInfo<Customer> getAllCustomerByPage(Integer page, Integer limit);
}
