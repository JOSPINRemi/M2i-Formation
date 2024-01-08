package dao;

import entity.Customer;

import java.util.List;

public interface ICustomerDAO {
    boolean save(Customer customer);
    Customer get(long customerId);
    List<Customer> get();
    boolean update(Customer customer);
    /*boolean delete(Customer customer);*/
}
