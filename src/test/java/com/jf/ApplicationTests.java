package com.jf;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jf.dao.BookDao;
import com.jf.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        System.out.println( bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("中华小子");
        book.setName("测试1");
        book.setDescription("测试23");
        bookDao.insert(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(13);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        bookDao.selectPage(page, null);
    }

    @Test
    void testGetBy() {
        String name = null;
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Book::getName, "spring");
        bookDao.selectList(queryWrapper);
    }

}
