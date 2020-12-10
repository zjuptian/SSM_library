package cn.tx.service;

import cn.tx.domain.Account;
import cn.tx.domain.Books;
import cn.tx.domain.User;

import java.util.List;

public interface AccountService {
    //查询所有
    public List<Account> findAll();

    void save(Account account);

    void delete(Integer id);

    public List<User> login(String account, String password);

    List<Books> getBooks();

    void rentBooks(String book_name);

    List<Books> getSingleBook(String book_name);

    void returnBooks(String book_name);

    void setRentRecord(String rent_date,String return_date,Integer book_id,Integer user_id);


    void setReturnRecord(Integer user_id, Integer book_id);
}
