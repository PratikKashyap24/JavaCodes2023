package com.url.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.url.service.UrlHandleService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlHandleController {
	
	@Autowired
	UrlHandleService urlService;
	
//	@PostMapping
//	public Url generateShortUrl(@RequestBody String url) {
//		return urlService.generateShortUrl(url);
//	}
//	
//	@GetMapping("/{shortLink}")
//	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response)
//	        throws IOException {
//		response.sendRedirect(urlService.getOriginalUrl(shortLink));
//		return null;
//	}

}
