package com.august.food.mapper;

import com.august.food.model.Food;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FoodMapper {
    @Select("select * from food")
    Food[] selectFoods();

    @Insert("INSERT INTO FOOD (name, price) VALUES(#{name}, #{price})")
    int insertFood(Food food);

    @Delete("delete from food where id=#{id}")
    int deleteFood(int id);

    @Select("select * from food where id=#{id}")
    Food findFood(int id);
}
