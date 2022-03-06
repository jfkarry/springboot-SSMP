package com.jf.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jf.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(int current, int pageSize, Book book);
}
