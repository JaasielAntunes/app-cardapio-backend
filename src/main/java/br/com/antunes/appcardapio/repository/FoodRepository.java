package br.com.antunes.appcardapio.repository;

import br.com.antunes.appcardapio.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
