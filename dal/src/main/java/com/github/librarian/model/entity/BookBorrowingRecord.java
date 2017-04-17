package com.github.librarian.model.entity;

import java.util.Date;

public class BookBorrowingRecord {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOOK_BORROWING_RECORD.ID
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOOK_BORROWING_RECORD.BORROWERID
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    private Integer borrowerid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOOK_BORROWING_RECORD.ISBN
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    private String isbn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOOK_BORROWING_RECORD.BORROWTIME
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    private Date borrowtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOOK_BORROWING_RECORD.RETURNTIME
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    private Date returntime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BOOK_BORROWING_RECORD.ISOVER
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    private Boolean isover;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOOK_BORROWING_RECORD.ID
     *
     * @return the value of BOOK_BORROWING_RECORD.ID
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOOK_BORROWING_RECORD.ID
     *
     * @param id the value for BOOK_BORROWING_RECORD.ID
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOOK_BORROWING_RECORD.BORROWERID
     *
     * @return the value of BOOK_BORROWING_RECORD.BORROWERID
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public Integer getBorrowerid() {
        return borrowerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOOK_BORROWING_RECORD.BORROWERID
     *
     * @param borrowerid the value for BOOK_BORROWING_RECORD.BORROWERID
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public void setBorrowerid(Integer borrowerid) {
        this.borrowerid = borrowerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOOK_BORROWING_RECORD.ISBN
     *
     * @return the value of BOOK_BORROWING_RECORD.ISBN
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOOK_BORROWING_RECORD.ISBN
     *
     * @param isbn the value for BOOK_BORROWING_RECORD.ISBN
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOOK_BORROWING_RECORD.BORROWTIME
     *
     * @return the value of BOOK_BORROWING_RECORD.BORROWTIME
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public Date getBorrowtime() {
        return borrowtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOOK_BORROWING_RECORD.BORROWTIME
     *
     * @param borrowtime the value for BOOK_BORROWING_RECORD.BORROWTIME
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOOK_BORROWING_RECORD.RETURNTIME
     *
     * @return the value of BOOK_BORROWING_RECORD.RETURNTIME
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public Date getReturntime() {
        return returntime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOOK_BORROWING_RECORD.RETURNTIME
     *
     * @param returntime the value for BOOK_BORROWING_RECORD.RETURNTIME
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public void setReturntime(Date returntime) {
        this.returntime = returntime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BOOK_BORROWING_RECORD.ISOVER
     *
     * @return the value of BOOK_BORROWING_RECORD.ISOVER
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public Boolean getIsover() {
        return isover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BOOK_BORROWING_RECORD.ISOVER
     *
     * @param isover the value for BOOK_BORROWING_RECORD.ISOVER
     *
     * @mbg.generated Tue Apr 18 00:17:07 CST 2017
     */
    public void setIsover(Boolean isover) {
        this.isover = isover;
    }
}