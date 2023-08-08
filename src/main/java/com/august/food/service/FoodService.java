package com.august.food.service;

import com.august.food.mapper.FoodMapper;
import com.august.food.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    private FoodMapper foodMapper;

    public int addFood(Food food) {
        return foodMapper.insertFood(food);
    }

    public Food[] getFoods() {
        return foodMapper.selectFoods();
    }

    public int deleteFood(int id) {
        return foodMapper.deleteFood(id);
    }

    public Food findFood(int id){
        return foodMapper.findFood(id);
    }
}
