package com.cross.bookmanager.controller;

import com.cross.bookmanager.model.Book;
import com.cross.bookmanager.model.Cart;
import com.cross.bookmanager.service.BookService;
import com.cross.bookmanager.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping(value =  "admin", method = RequestMethod.GET)
    public String listBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "admin";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if(book.getId() == 0){
            this.bookService.addBook(book);
        }else{
            this.bookService.updateBook(book);
        }

        return "redirect:/admin";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.bookService.removeBook(id);

        return "redirect:/admin";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "admin";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }

    @RequestMapping(value = "/books/add/{id}", method = RequestMethod.POST)
    public String addBookCart(Model model, @PathVariable("id") int id){
        model.addAttribute("book",this.bookService.getBookById(id));
        return "redirect:/books";
    }
}
