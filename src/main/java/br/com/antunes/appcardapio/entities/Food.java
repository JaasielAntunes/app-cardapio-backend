package br.com.antunes.appcardapio.entities;

import br.com.antunes.appcardapio.dto.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.util.Locale;

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

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double price;

    @Transient
    private String priceFormat;

    public Food(FoodRequestDTO data) {
        this.imgUrl = data.imgUrl();
        this.price = data.price();
        this.title = data.title();
    }

    public void setPrice(double price) {
        this.price = price;
        this.priceFormat = priceFormat(price);
    }

    public String getPriceFormat() {
        return priceFormat;
    }

    private String priceFormat(double price) {
        NumberFormat formatBR = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return "R$ " + formatBR.format(price);
    }
}