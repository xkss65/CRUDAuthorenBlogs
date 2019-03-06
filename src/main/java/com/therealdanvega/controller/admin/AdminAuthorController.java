package com.therealdanvega.controller.admin;

import com.therealdanvega.domain.Author;
//import com.therealdanvega.domain.Post;
import com.therealdanvega.service.AuthorService;
//import com.therealdanvega.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Secured( {"ROLE_ADMIN"} )
public class AdminAuthorController {

	private AuthorService authorService;

	@Autowired
//	public AdminAuthorController(AuthorService authorService, AuthorService authorService) {
	public AdminAuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@RequestMapping("/admin/authors")
	public String list(Model model) {
		model.addAttribute("authors", authorService.list());
//		return "admin/author/list";
 		return "admin.author/list";
//		C:\Users\XKSS\projects\delete\src\main\resources\templates\admin.author\list.html

//	@ResponseBody()
//	public String list() {
//		return "admin/author/list";
		}
	
	@RequestMapping("/admin/author/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorService.get(id));
//		return "admin/author/view";
		return "admin.author/view";
	}
	
	// create | save
	
	@RequestMapping("/admin/author/create")
	public String create(Model model) {
		model.addAttribute("author", new Author());
//		return "admin/author/authorForm";
		return "admin.author/authorForm";
	}
	
	@RequestMapping( value = "/admin.author/save", method = RequestMethod.POST )
	public String save(@Valid Author author, BindingResult bindingResult, Model model) {
				
		if( bindingResult.hasErrors() ){
			model.addAttribute("authors", authorService.list());
//			return "admin/author/authorForm";
			return "admin.author/authorForm";
		} else {
			Author savedAuthor = authorService.save(author);
			return "redirect:/admin/author/" + savedAuthor.getId();
//			return "redirect:/admin.author/" + savedAuthor.getId();
//			return "redirect:/admin/author/";
		}

	}
	
	@RequestMapping("/admin/author/edit/{id}")
	public String edit(@PathVariable Long id, Model model){
		model.addAttribute("author", authorService.get(id));
//		return "admin/author/authorForm";
		return "admin.author/authorForm";
	}
	
	@RequestMapping("/admin/author/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		authorService.delete(id);
		redirectAttrs.addFlashAttribute("message", "Author was deleted!");
		return "redirect:/admin/authors";
	}
	
}
