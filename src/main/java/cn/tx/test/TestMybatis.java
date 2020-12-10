package cn.tx.test;

import cn.tx.dao.AccountDao;
import cn.tx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     * 测试查询
     */
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //构建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建session
        SqlSession session  = factory.openSession();
        //获取到代理对象
        AccountDao mapper = session.getMapper(AccountDao.class);
        //调用方法
        List<Account> list = mapper.findAll();
        for(Account account:list){
            System.out.println(account);
        }
        //关闭资源
        session.close();
        inputStream.close();

    }
}
