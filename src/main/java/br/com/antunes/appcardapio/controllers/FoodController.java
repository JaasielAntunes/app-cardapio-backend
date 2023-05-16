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
@CrossOrigin(origins = "http://localhost:5173/, http://localhost:3000/")
public class FoodController {

    @Autowired
    final FoodRepository repo;

    @PostMapping("/cadastrar")
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repo.save(foodData);
    }

    @GetMapping("/listar")
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repo.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

//    @GetMapping("/listar")
//    public ResponseEntity<Page<Food>> getAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
//        Page<Food> foodPage = repo.findAll(pageable);
//        return ResponseEntity.status(HttpStatus.OK).body(foodPage); (Listagem para teste exclusivo do backend.)
//    }
}
