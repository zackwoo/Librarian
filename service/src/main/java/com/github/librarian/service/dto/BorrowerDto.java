package com.github.librarian.service.dto;


import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zack.wu on 2017/4/18.
 */
@Component
public class BorrowerDto  {
    private Integer id;
    private String name;
    private Integer email;
    private  Integer status;
    private List<BorrowerBookDto> booksDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<BorrowerBookDto> getBooksDto() {
        return booksDto;
    }

    public void setBooksDto(List<BorrowerBookDto> booksDto) {
        this.booksDto = booksDto;
    }
}
