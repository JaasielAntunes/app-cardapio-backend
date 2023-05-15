package br.com.antunes.appcardapio.controllers;

import br.com.antunes.appcardapio.dto.FoodRequestDTO;
import br.com.antunes.appcardapio.dto.FoodResponseDTO;
import br.com.antunes.appcardapio.entities.Food;
import br.com.antunes.appcardapio.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
@RequiredArgsConstructor
@CrossOrigin(origins = "localhost:3000/")
public class FoodController {

    @Autowired
    final FoodRepository repo;

    @PostMapping("/cadastrar")
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repo.save(foodData);
    }

    @GetMapping("/listar-todos")
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repo.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
