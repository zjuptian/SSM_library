package cn.tx.service;

import cn.tx.dao.AccountDao;
import cn.tx.dao.BooksDao;
import cn.tx.dao.RecordDao;
import cn.tx.dao.UserDao;
import cn.tx.domain.Account;
import cn.tx.domain.Books;
import cn.tx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    public AccountDao accountDao;
    @Autowired
    public UserDao userDao;
    @Autowired
    public BooksDao booksDao;
    @Autowired
    public RecordDao recordDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有账号...");
        return accountDao.findAll();
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    @Override
    public List<User> login(String account, String password) {
        System.out.println("业务层，查询所有账号...");
        return userDao.login(account,password);
    }

    @Override
    public List<Books> getBooks() {
        System.out.println("业务层，查询所有书籍信息...");
        return booksDao.getBooks();
    }

    @Override
    public void rentBooks(String book_name) {
        booksDao.rentBooks(book_name);
    }

    @Override
    public List<Books> getSingleBook(String book_name) {
        return booksDao.getSingleBook(book_name);
    }

    @Override
    public void returnBooks(String book_name) {
        booksDao.returnBooks(book_name);
    }

    @Override
    public void setRentRecord(String rent_date, String return_date, Integer book_id, Integer user_id) {
        recordDao.setRentRecord(rent_date,return_date,book_id,user_id);
    }

    @Override
    public void setReturnRecord(Integer user_id, Integer book_id) {
        recordDao.setReturnRecord(user_id,book_id);
    }


}
