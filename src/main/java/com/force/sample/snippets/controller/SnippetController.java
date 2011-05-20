package com.force.sample.snippets.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.force.sample.snippets.model.Snippet;

@Controller
public class SnippetController {
	
	@PersistenceContext
	EntityManager em;
	
//	@ModelAttribute("snippet")
//	public Snippet addSnippet(@PathVariable String id) {
//		if (id.equalsIgnoreCase("new"))
//			return new Snippet();
//		
//		return em.find(Snippet.class, id);
//	}
	
	@RequestMapping(value="/snippet/", method=RequestMethod.GET)
	public ModelAndView get() {
		ModelAndView mv = new ModelAndView();
		List<Snippet> snippets = em.createQuery("Select s From Snippet s").getResultList();
		mv.addObject("snippets", snippets);
		mv.setViewName("editor");
		return mv;
	}
}
