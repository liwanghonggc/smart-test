package org.smart4j.chapter3.controller;

import org.smart4j.chapter3.model.Customer;
import org.smart4j.chapter3.service.CustomerService;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;

import java.util.List;
import java.util.Map;

/**
 * 处理客户管理相关请求
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 进入客户列表界面
     */
    @Action("get:/customer")
    public View index(){
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    /**
     * 显示客户基本信息
     */
    @Action("get:/customer_show")
    public View show(Param param){
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    /**
     * 进入创建客户界面
     */
    @Action("get:/customer_create")
    public View create(){
        return new View("customer_create.jsp");
    }

    /**
     * 处理创建客户请求
     */
    @Action("post:/customer_create")
    public Data createSubmit(Param param){
        Map<String, Object> fieldMap = param.getParamMap();

        FileParam fileParam = param.getFile("photo");

        boolean result = customerService.createCustomer(fieldMap, fileParam);
        return new Data(result);
    }

    /**
     * 进入编辑客户界面
     */
    @Action("get:/customer_edit")
    public View edit(Param param){
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    /**
     * 处理编辑客户请求
     */
    @Action("put:/customer_edit")
    public Data editSubmit(Param param){
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getParamMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    /**
     * 处理删除客户请求
     */
    @Action("get:/customer_delete")
    public Data delete(Param param){
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }

}
