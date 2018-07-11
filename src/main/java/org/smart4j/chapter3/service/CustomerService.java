package org.smart4j.chapter3.service;

import org.smart4j.chapter3.model.Customer;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.helper.UploadHelper;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    /**
     * 查询客户列表
     */
    public List<Customer> getCustomerList(){
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql, null);
    }

    /**
     * 查询客户
     */
    public Customer getCustomer(Long id){
        String sql = "select * from customer where id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     * @param fieldMap
     * @return
     */
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam){
        //先保存基本信息
        boolean result = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        //再处理文件信息
        if(result){
            UploadHelper.uploadFile("/tmp/upload/", fileParam);
        }
        return result;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map fieldMap){
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    @Transaction
    public boolean deleteCustomer(long id){
        boolean result = DatabaseHelper.deleteEntity(Customer.class, id);

        //开启事务后,若此处发生异常,数据库中数据不会被删除
        //若不开始事务,此处发生异常,数据库中数据会被删除,说明事务AOP配置生效了
        //int i = 1 / 0;

        return result;
    }
}
