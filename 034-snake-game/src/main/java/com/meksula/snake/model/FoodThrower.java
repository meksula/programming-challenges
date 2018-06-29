package com.meksula.snake.model;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public interface FoodThrower {
    Block giveFood(List<Block> rectangleList);
}
