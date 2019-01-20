package com.ascii.art.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ascii.art.command.ASCIIArtCommand;
import com.ascii.art.service.impl.ASCIIArtServiceImpl;

@Controller
public class ASCIIArtController {

	@Autowired
	private ASCIIArtServiceImpl ASCIIArtService;

	@ModelAttribute("selectDesignPrintValue")
	public String[] getSelectDesignPrintValue() {
		return new String[] { "*", "~", "`", "!", "@", "#", "$", "%", "^", "&", "(", ")", "-", "_", "+", "=", "{", "}",
				"|", "[", "]", "\\", "<", ">", "?", ",", ".", "/", ":", ";", "'", "\"" };
	}

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("command", new ASCIIArtCommand());

		return "home";

	}

	@PostMapping("/asciiform")
	public String submitASCIIText(@Valid @ModelAttribute("command") ASCIIArtCommand command, BindingResult bindingResult,
			Model model, RedirectAttributes ra) throws IOException {

		System.out.println("after submission" + command.toString());
		

		if (bindingResult.hasErrors()) {
			return "home";
		}

		String[][] generateASCIIArt = ASCIIArtService.generateASCIIArt(command.getTextAscii(),
				command.getDesignPrintValue());

		command.setTextareaAscii(generateASCIIArt);

		ra.addFlashAttribute("command", command);

		return "redirect:/asciiresult";
	}

	@GetMapping("/asciiresult")
	public String fooresult(@ModelAttribute("command") ASCIIArtCommand command, Model model) {

		System.out.println("Result" + command.toString());

		return "home";
	}

}
