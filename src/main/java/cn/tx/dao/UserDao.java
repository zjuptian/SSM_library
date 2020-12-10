package cn.tx.dao;

import cn.tx.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user_info where account=#{account} and password=#{password}")
    public List<User> login(@Param("account") String account, @Param("password") String password);
}
