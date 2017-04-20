package com.github.librarian.service.impl;

import com.github.librarian.model.mapper.BorrowerMapper;
import com.github.librarian.service.dto.BorrowerDto;
import com.github.librarian.service.dto.BorrowerRegisterDto;
import com.github.librarian.service.interfaces.IBorrowerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zachary on 2017/4/18.
 */

@Service
public class BorrowerServiceImpl implements IBorrowerService{

    @Autowired
    private BorrowerMapper mapper;

    public void register(BorrowerRegisterDto borrowerRegisterDto) {

    }

    public boolean ban(int borrowerId) {
        return false;
    }

    public boolean enable(int borrowerId) {
        return false;
    }

    public PageInfo<BorrowerDto> queryBorrower(int pageNumber, int pageSize) {
        return null;
    }
}
