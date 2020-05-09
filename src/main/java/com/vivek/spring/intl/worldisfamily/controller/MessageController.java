package com.vivek.spring.intl.worldisfamily.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.spring.intl.worldisfamily.configuration.Translator;

@RestController
/*
 * Annotation for mapping web requests onto methods in request-handling classeswith flexible method signatures. 
 */
@RequestMapping(value = "/api")
public class MessageController {
	
   /*
    * Annotation which indicates that a method parameter should be bound to a webrequest parameter. 	
    */
   @GetMapping
   public String getMessage(@RequestParam("msg") String msg) {
	   return Translator.toLocale(msg);
   }
}
