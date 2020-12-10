package cn.tx.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface RecordDao{
    @Insert("insert into record (rent_date,return_date,book_id,user_id) values(#{rent_date},#{return_date},#{book_id},#{user_id}) ")
    public void setRentRecord(@Param("rent_date") String rent_date, @Param("return_date") String return_date, @Param("book_id") Integer book_id, @Param("user_id") Integer user_id);

    @Delete("delete from record where user_id = #{user_id} and book_id = #{book_id}")
    public void setReturnRecord(@Param("user_id") Integer user_id, @Param("book_id") Integer book_id);
}
