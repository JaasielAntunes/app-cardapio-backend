package br.com.antunes.appcardapio.services;

import br.com.antunes.appcardapio.entities.Food;
import br.com.antunes.appcardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repo;

    public Page<Food> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
