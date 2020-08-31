package com.social_link_generator.social_link_generator.controllers;

import com.social_link_generator.social_link_generator.services.LinkGeneratorService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkGeneratorController {

    private LinkGeneratorService linkGeneratorService;

    public LinkGeneratorController(LinkGeneratorService linkGeneratorService) {
        this.linkGeneratorService = linkGeneratorService;
    }

    /**
     * Display the input page
     * 
     * @return
     */
    @GetMapping("/")
    public String showPage() {
        return "index";
    }

    /**
     * Generate the sharable links with trackers from the input URL
     */
    @PostMapping("/")
    public String generateLink(@RequestParam(name = "url") String url, Model model) {
        model.addAttribute("links", linkGeneratorService.generateShareableLinks(url));
        return "index";
    }

}