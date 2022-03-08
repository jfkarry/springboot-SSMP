package com.jf.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jf.domain.Book;
import com.jf.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private IBookService ibookService;
    @Test

    void save() {
        Book book = new Book();
        book.setType("中华");
        book.setName("测试g");
        book.setDescription("测试23");
        System.out.println(ibookService.save(book));
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(14);
        book.setType("中华小子");
        book.setName("测试3");
        book.setDescription("测试46");
        System.out.println( ibookService.updateById(book));
    }

    @Test
    void delete() {
        System.out.println(ibookService.removeById(16));
    }

    @Test
    void getById() {
        System.out.println(ibookService.getById(1));
    }

    @Test
    void getAll() {
        System.out.println(ibookService.list());
    }


    @Test
    void getByPage() {
        IPage<Book> page = new Page<Book>(1,5);
        System.out.println( ibookService.page(page).getRecords());
    }
}