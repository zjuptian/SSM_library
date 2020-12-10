package cn.tx.dao;

import cn.tx.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {
    @Select(value = "select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money) values(#{name},#{money})" )
    void save(Account account);

    @Insert("delete from account where id = #{id}")
    void delete(Integer id);
}
