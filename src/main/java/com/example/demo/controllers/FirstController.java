package com.example.demo.controllers;

import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Brewery;
// import com.example.demo.models.Review;
import com.example.demo.services.BreweryService;
// import com.example.demo.services.ReviewService; // Add this line

// Import other necessary dependencies

@Controller
public class FirstController {
    private final BreweryService breweryService;
    // private final ReviewService reviewService; // Add this line

    public FirstController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping("/review")
    public String review() {
        return "review";
    }

    @GetMapping("/search")
    public String searchBreweries(@RequestParam(required = false) String searchCity,
                                  @RequestParam(required = false) String searchName,
                                  @RequestParam(required = false) String searchType,
                                  Model model) {
        List<Brewery> breweries = breweryService.searchBreweries(searchCity, searchName, searchType);
        model.addAttribute("breweries", breweries);
        model.addAttribute("searchCity", searchCity);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchType", searchType);
        return "search";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}
