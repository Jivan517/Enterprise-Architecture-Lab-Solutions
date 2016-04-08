package cs544.exercise9;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cs544.sample.NoSuchResourceException;

@Controller
public class BookController {

	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	@Resource
	private IBookDao bookDao;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books", bookDao.getAll());
		return "bookList";
	}
	
	@RequestMapping(value="/books/add", method=RequestMethod.POST)
	public String add(@Valid Book book, BindingResult result) {
		
		if(result.hasErrors()){
			return "addBook";
		}
		
		bookDao.add(book);
		System.out.println("Adding book");
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books/add", method=RequestMethod.GET)
	public String addBook(Model model){
		
		model.addAttribute("book", new Book());
		return "addBook";
	}

	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "bookDetail";
	}
	
	
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.POST)
	public String update(Book book, @PathVariable int id) {
		bookDao.update(id, book); // book.id already set by binding
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books/delete", method=RequestMethod.POST)
	public String delete(int bookId) {
		bookDao.delete(bookId);
		return "redirect:/books";
	}


	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}
}
