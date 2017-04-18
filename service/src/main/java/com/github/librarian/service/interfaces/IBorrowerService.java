package com.github.librarian.service.interfaces;

import com.github.librarian.service.dto.BorrowerDto;
import com.github.librarian.service.dto.BorrowerRegisterDto;
import com.github.pagehelper.PageInfo;

/**
 * Created by zack.wu on 2017/4/18.
 */
public interface IBorrowerService {
    /**
     * 注册用户
     * @param borrowerRegisterDto
     */
    void register (BorrowerRegisterDto borrowerRegisterDto);

    /**
     * 冻结借阅者账号
     * @param borrowerId
     * @return
     */
    boolean ban(int borrowerId);

    /**
     * 激活借阅者账号
     * @param borrowerId
     * @return
     */
    boolean enable(int borrowerId);

    /**
     * 查阅所有借阅者借阅信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<BorrowerDto> queryBorrower(int pageNumber,int pageSize);
}
