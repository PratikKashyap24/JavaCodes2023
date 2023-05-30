package com.dxc.swlms.controller;

import java.time.LocalDate;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.swlms.entity.Book;
import com.dxc.swlms.exception.LibraryException;
import com.dxc.swlms.service.BookService;

@Controller
public class LibraryController {
	@Autowired
	private BookService bookService;

	@GetMapping({ "", "/", "/home" })
	public ModelAndView bookList() throws LibraryException{
		return new ModelAndView("bookListPage", "books", bookService.getAllBooks());
	}

	@GetMapping("/newBook")
	public ModelAndView newBook() {
		return new ModelAndView("bookFormPage", "book", new Book());
	}

	@GetMapping("/newBook")
	public ModelAndView doNewItem(@Valid @ModelAttribute("book") Book book, BindingResult result)
			throws LibraryException {
		ModelAndView mv;

		if (result.hasErrors()) {
			mv = new ModelAndView("bookFormPage", "book", book);
		}

		else {
			bookService.add(book);
			mv = new ModelAndView("redirect:/home");
		}

		return mv;
	}

	@GetMapping("/deleteBook")
	public ModelAndView deleteBook(@RequestParam(name = "bCode") int bCode) throws LibraryException {
		return new ModelAndView("deletePage", "book", bookService.getByBcode(bCode));

	}

	@GetMapping("/deleteBook")
	public String ConfirmDelete(@RequestParam(name = "bCode") int bCode,
			@RequestParam(name = "confirm") boolean confirm) throws LibraryException {

		if (confirm) {
			bookService.deleteBook(bCode);
		}
		return "redirect:/home";
	}

	@GetMapping("/editBook")
	public ModelAndView editBook(@RequestParam(name = "bCode") int bCode) throws LibraryException {

		return new ModelAndView("bookFormPage", "book", bookService.getByBcode(bCode));

	}

	@GetMapping("/editBook")
	public ModelAndView doUpdateBook(@Valid @ModelAttribute("book") Book book, BindingResult result)
			throws LibraryException {
		ModelAndView mv;

		if (result.hasErrors()) {
			mv = new ModelAndView("bookFormPage", "book", book);
		} else {
			bookService.update(book);
			mv = new ModelAndView("redirect:/home");

		}

		return mv;

	}

	@GetMapping("/findByBname")
	public ModelAndView bookByTitle(@RequestParam("bname") String bname) throws LibraryException {
		return new ModelAndView("bookListPage", "books", Collections.singleton(bookService.findByBname(bname)));

	}

	@GetMapping("/findByPackageDate")
	public ModelAndView bookByBDate(@DateTimeFormat(iso = ISO.DATE) @RequestParam("packageDate") LocalDate packageDate)
			throws LibraryException {
		return new ModelAndView("bookListPage", "books", bookService.findByPackageDate(packageDate));

	}

	@GetMapping("/findByPriceRange")

	public ModelAndView bookByPrice(@RequestParam("lb") double lowerBound, @RequestParam("ub") double upperBound)
			throws LibraryException {
		return new ModelAndView("bookListPage", "books", bookService.findInPriceRange(lowerBound, upperBound));

	}

}
