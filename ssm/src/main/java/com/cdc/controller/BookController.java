package com.cdc.controller;

import com.cdc.pojo.Books;
import com.cdc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("list",booksList);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("qBook",books);
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
       bookService.updateBook(books);
       return "redirect:/book/allBook";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/queryBookByName")
    public String queryBookByName(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        model.addAttribute("list",list);
        return "allBook";

    }
}
