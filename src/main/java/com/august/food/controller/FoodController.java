package com.august.food.controller;

import com.august.food.model.Food;
import com.august.food.service.FoodService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/home")
    public String getHome(Model model, Food food) {
        Food[] foods = foodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    }

    @PostMapping("/home")
    public String addFood(Model model, Food food) {
        if (food.getPrice() > 1000) {
            model.addAttribute("errorMessage", String.format("Could not add %s! Too expensive seyo", food.getName()));
        } else if (foodService.addFood(food) < 1) {
            model.addAttribute("errorMessage", String.format("Could not add %s", food.getName()));
        } else {
            model.addAttribute("successMessage", String.format("Successfully added %s", food.getName()));
        }
        Food[] foods = foodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    }

    @GetMapping("/home/{id}")
    public String deleteFood(Model model, Food food, @PathVariable int id){
        Food _food = foodService.findFood(id);
        if (foodService.deleteFood(_food.getId()) < 1) {
            model.addAttribute("errorMessage", String.format("Could not delete %s", _food.getName()));
        } else {
            model.addAttribute("successMessage", String.format("Successfully deleted %s", _food.getName()));
        }

        Food[] foods = foodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    };

}
