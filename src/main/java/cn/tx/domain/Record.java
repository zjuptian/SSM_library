package cn.tx.domain;

import java.io.Serializable;

public class Record implements Serializable {
    private Integer id;
    private String rent_date;
    private String return_date;
    private Integer book_id;
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", rent_date='" + rent_date + '\'' +
                ", return_date='" + return_date + '\'' +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                '}';
    }
}
