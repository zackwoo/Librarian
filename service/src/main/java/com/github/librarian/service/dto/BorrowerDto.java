package com.github.librarian.service.dto;


import java.util.List;

/**
 * Created by zack.wu on 2017/4/18.
 */
public class BorrowerDto  {
    private Integer borrowerId;
    private String borrowerName;
    private Integer borrowerStatus;
    private List<BorrowerBookDto> booksDto;

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Integer getBorrowerStatus() {
        return borrowerStatus;
    }

    public void setBorrowerStatus(Integer borrowerStatus) {
        this.borrowerStatus = borrowerStatus;
    }

    public List<BorrowerBookDto> getBooksDto() {
        return booksDto;
    }

    public void setBooksDto(List<BorrowerBookDto> booksDto) {
        this.booksDto = booksDto;
    }
}
