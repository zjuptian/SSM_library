package cn.tx.dao;

import cn.tx.domain.Books;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BooksDao {

    @Select("select * from books")
    public List<Books> getBooks();

    @Select("select * from books where book_name = #{book_name}")
    public List<Books> getSingleBook(String book_name);

    @Update("update books set count=count-1 where book_name=#{book_name}")
    public void rentBooks(String book_name);

    @Update("update books set count=count+1 where book_name=#{book_name}")
    void returnBooks(String book_name);
}
