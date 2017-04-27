package com.github.librarian.controller;

import com.alibaba.fastjson.JSON;
import com.github.librarian.service.common.GeneralService;
import com.github.librarian.service.dto.AddBookDto;
import com.github.librarian.service.dto.BookDto;
import com.github.librarian.service.interfaces.IBookService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by zachary on 2017/4/18.
 */
@RestController
@RequestMapping("/api/book")
@Api(value = "图书服务类",description = "图书资源")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GeneralService generalService;

    @ApiOperation(value = "根据图书编号查询单本图书")
    @GetMapping("queryBookByISBN")
    private BookDto queryBookByISBN(@ApiParam(value = "图书编号",defaultValue = "9047-64-438-933-93") @RequestParam String isbn) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (BookDto)generalService.selectByPrimaryKey("book",isbn,BookDto.class);
    }


    @ApiOperation(value = "根据图书名称查询图书信息", notes = "支持模糊查询")
    @GetMapping("queryBookByName")
    private PageInfo<BookDto> queryBookByName(@RequestParam @ApiParam(defaultValue = "{pageNumber:1,NameLike:\"%a%\"}") String mapJson) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Map map = JSON.parseObject(mapJson, Map.class);
        return (PageInfo<BookDto>) generalService.selectByExample("book",map,BookDto.class);
    }


    @ApiOperation(value = "添加书籍",notes = "书籍如果已经存在则返回false")
    @PostMapping("addBook")
    private boolean addBook(@RequestBody AddBookDto dto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object book = generalService.selectByPrimaryKey("book", dto.getIsbn());
        if (book == null) return false;
        int count = generalService.insert("book", dto);
        return count == 1;
    }
}
