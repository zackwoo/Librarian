package com.github.librarian.service.dto;

/**
 * Created by zack.wu on 2017/4/28.
 */
public class LossBookDto {
    public String isbn;
    public int count;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
