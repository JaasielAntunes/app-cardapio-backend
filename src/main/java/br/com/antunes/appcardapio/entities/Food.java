package br.com.antunes.appcardapio.entities;

import br.com.antunes.appcardapio.dto.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "foods")
@Entity(name = "foods")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imgUrl;

    private Double price;

    public Food(FoodRequestDTO data) {
        this.imgUrl = data.imgUrl();
        this.price = data.price();
        this.title = data.title();
    }
}