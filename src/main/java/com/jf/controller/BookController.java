package com.jf.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jf.controller.utils.R;
import com.jf.domain.Book;
import com.jf.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;
    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
      return new R(bookService.save(book))  ;
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return  new R(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        if (currentPage > pageSize) {
            page = bookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }
}
