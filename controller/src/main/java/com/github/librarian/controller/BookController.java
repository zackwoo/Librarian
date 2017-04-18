package com.github.librarian.controller;

import com.github.librarian.service.dto.BookDto;
import com.github.librarian.service.interfaces.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zachary on 2017/4/18.
 */
@RestController
@RequestMapping("/api/book")
@Api(value = "图书服务类",description = "图书资源")
public class BookController {

    @Autowired
    private IBookService bookService;

    @ApiOperation(value = "根据图书编号查询单本图书")
    @GetMapping("queryBookByISBN")
    private BookDto queryBookByISBN(@ApiParam(name = "图书编号") @RequestParam String isbn){
        return bookService.queryBookByISBN(isbn);
    }


}
