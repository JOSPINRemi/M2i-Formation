package dao;

import entity.Account;
import entity.Customer;

import java.util.List;

public interface IAccountDAO {
    boolean save(Account account);
    /*Account get(long id);
    List<Account> get();
    boolean update(Account account);
    boolean delete(Account account);*/
}
