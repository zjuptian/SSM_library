package cn.tx.domain;

public class Books {
    private Integer id;
    private String book_name;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", count=" + count +
                '}';
    }
}
