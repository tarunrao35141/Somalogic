package com.kata.tarun.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.kata.tarun.service.CountHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
public class StudentController {

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
								   RedirectAttributes redirectAttributes) throws  Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");
		int total = CountHandler.getNumberOfLines(br);
		System.out.println(total);
		return "Total Number of lines:"+total;
	}

	@GetMapping("/hello")
	public String retrieveCoursesForStudent1() {
		return "hi how are you";
	}

}
