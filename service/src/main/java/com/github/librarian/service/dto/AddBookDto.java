package com.github.librarian.service.dto;

/**
 * Created by zack.wu on 2017/4/27.
 */
public class AddBookDto {
    private String isbn;
    private String name;
    private String intro;
    private  int count;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
