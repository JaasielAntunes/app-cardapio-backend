package br.com.antunes.appcardapio.dto;

import br.com.antunes.appcardapio.entities.Food;

public record FoodResponseDTO(Long id, String title, String imgUrl, Double price) {

    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getImgUrl(), food.getPrice());
    }
}
