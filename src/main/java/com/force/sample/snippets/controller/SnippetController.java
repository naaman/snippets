package com.force.sample.snippets.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.force.sample.snippets.model.Snippet;

@Controller
public class SnippetController {
	
	@PersistenceContext
	EntityManager em;
	
	@ModelAttribute("snippet")
	public Snippet addSnippet(@PathVariable String id) {
		if (id.equalsIgnoreCase("new"))
			return new Snippet();
		
		return em.find(Snippet.class, id);
	}
	
	@RequestMapping(value="/snippet/{id}", method=RequestMethod.GET)
	public ModelAndView get(ModelAndView mv, @ModelAttribute("snippet") Snippet snippet) {
		mv.addObject("snippet", snippet);
		mv.setViewName("editor");
		return mv;
	}
}
