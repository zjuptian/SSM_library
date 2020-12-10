package cn.tx.controller;

import cn.tx.domain.Account;
import cn.tx.domain.Books;
import cn.tx.domain.User;
import cn.tx.service.AccountService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    //依赖注入，注入成功即可调用service对象方法
    private int user_id;
    public class Result{
        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    @Autowired
    private AccountService accountService;

    @RequestMapping("/test.do")
    @ResponseBody
    public Result getResult(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("访问成功");
        return result;
    }


    @RequestMapping("/login.do")
    @ResponseBody
    @CrossOrigin
    public Result login(String account, String password){
        System.out.println("表现层，登录...");
        System.out.println(account+"   "+password);
        List<User> list = accountService.login(account,password);
        Result result = new Result();
        if(!list.isEmpty()){
            user_id = list.get(0).getId();
            result.setCode(200);
            result.setMsg("访问成功");
        }
        else{
            result.setCode(100);
            result.setMsg("访问失败");
        }
        System.out.println("code:"+result.getCode()+"   msg:"+result.getMsg());
        return result;
    }

    @RequestMapping("/getBooks.do")
    @ResponseBody
    @CrossOrigin
    public Result getBooks(){
        System.out.println("表现层，获取书籍信息...");
        List<Books> list = accountService.getBooks();
        String booksInfo = JSON.toJSONString(list);
        Result result = new Result();
        result.setCode(200);
        result.setMsg(booksInfo);
        return result;
    }

    @RequestMapping("/rentBooks.do")
    @ResponseBody
    @CrossOrigin
    public Result rentBooks(String book_name){
        Date rent_date = new Date();
        Date return_date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rent_date);
        calendar.add(Calendar.MONTH,3);
        return_date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String defaultRentDate = sdf.format(rent_date);
        String defaultReturnDate = sdf.format(return_date);


        System.out.println("表现层，借阅书籍...");
        List<Books> list = accountService.getSingleBook(book_name);
        int count = list.get(0).getCount();
        Result result = new Result();
        if(count == 0){
            result.setCode(100);
            result.setMsg("该书已借完！");
        }
        else{
            result.setCode(200);
            result.setMsg("借阅成功！");
            Integer book_id = list.get(0).getId();
            accountService.rentBooks(book_name);
            accountService.setRentRecord(defaultRentDate,defaultReturnDate,book_id,user_id);

        }
        return result;

    }


    @RequestMapping("/returnBooks.do")
    @ResponseBody
    @CrossOrigin
    public Result returnBooks(String book_name){
        System.out.println("表现层，归还书籍...");
        accountService.returnBooks(book_name);
        List<Books> list = accountService.getSingleBook(book_name);
        Integer book_id = list.get(0).getId();
        accountService.setReturnRecord(user_id,book_id);
        Result result = new Result();
        result.setCode(200);
        result.setMsg("归还成功");
        return result;
    }



    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        System.out.println("表现层，查询所有的账户...");
        //调用service对象方法
        List<Account> list  = accountService.findAll();
        for(Account account:list){
            System.out.println(account);
        }
        String result = JSON.toJSONString(list);
        ModelAndView mv = new ModelAndView("/table");
        //设置跳转页面
//        mv.setViewName("/suc");
        mv.addObject("result", result);
        return mv;
    }

    /**
     * 保存
     * @return
     */
    @RequestMapping("/save.do")
    public ModelAndView save(String name, Double money){
        System.out.println("表现层，添加账户并返回...");
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        //调用service 保存数据
        accountService.save(account);
        List<Account> list  = accountService.findAll();
        System.out.println(list.toString());
        String result = JSON.toJSONString(list);
        for(Account account_one:list){
            System.out.println(account_one);
        }
        ModelAndView mv = new ModelAndView("/table");
        mv.addObject("result", result);
        return mv;
    }

    @RequestMapping("/delete.do")
    public ModelAndView delete(Integer id){
        System.out.println("表现层，删除用户...");
        //调用service 保存数据
        accountService.delete(id);
        List<Account> list  = accountService.findAll();
        System.out.println(list.toString());
        String result = JSON.toJSONString(list);
        for(Account account_one:list){
            System.out.println(account_one);
        }
        ModelAndView mv = new ModelAndView("/table");
        mv.addObject("result", result);
        return mv;
    }

}
