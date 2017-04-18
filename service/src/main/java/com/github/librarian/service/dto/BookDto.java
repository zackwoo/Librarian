package com.github.librarian.service.dto;

/**
 * Created by zack.wu on 2017/4/18.
 */
public class BookDto {
    private String isbn;
    private String name;
    private String intro;

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
}
