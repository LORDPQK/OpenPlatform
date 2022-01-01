package pqk.project1.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pqk.project1.openapi.web.master.bean.AjaxMessage;
import pqk.project1.openapi.web.master.bean.TableData;
import pqk.project1.openapi.web.master.pojo.Customer;
import pqk.project1.openapi.web.master.service.CustomerService;

@RestController
@RequestMapping("/sys/customer")
public class CoustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public AjaxMessage addCustomer(Customer customer){

        try{
            customerService.insertCustomer(customer);
            return new AjaxMessage(true,"添加成功");
        }catch(Exception e){
            return  new AjaxMessage(false,"添加失败");
        }
    }

    @PostMapping("/update")
    public AjaxMessage updateCustomer(Customer customer){
        try{
            customerService.updateCustomer(customer);
            return new AjaxMessage(true,"更新成功");
        }catch(Exception e){
            return  new AjaxMessage(false,"更新失败");
        }
    }

    @PostMapping("/del")
    public AjaxMessage deleteCustomer(long[] ids){
            if(ids!=null && ids.length>0){
                customerService.deleteCustomerByIds(ids);
                return new AjaxMessage(true,"更新成功");
            }
            return  new AjaxMessage(false,"更新失败");
    }



    @GetMapping("/table")
    public TableData<Customer> table(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "2")Integer limit){
        //创建返回结果的封装对象
        TableData<Customer> customerTableData = new TableData<Customer>();
        //按照分页查询数据，通过pageHelper查询
        PageInfo<Customer> allCustomerByPage = customerService.getAllCustomerByPage(page, limit);
        //设置总条数
        customerTableData.setCount(allCustomerByPage.getTotal());
        //设置数据
        customerTableData.setData(allCustomerByPage.getList());

        return customerTableData;

    }



}
