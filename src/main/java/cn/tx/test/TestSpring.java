package cn.tx.test;

import cn.tx.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1(){
        //创建工厂，加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取service对象，调用方法
        AccountService service = ac.getBean(AccountService.class);
        service.findAll();
    }
}
