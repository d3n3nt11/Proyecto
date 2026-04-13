package com.example.fuegoypan.test;

import com.example.fuegoypan.model.*;
import com.example.fuegoypan.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CreateTestData implements CommandLineRunner {

    private final ProductRepo productRepo;
    private final IngredientRepo ingredientRepo;
    private final RecipeRepo recipeRepo;
    private final StockIngredientRepo stockRepo;

    public CreateTestData(ProductRepo productRepo,
                          IngredientRepo ingredientRepo,
                          RecipeRepo recipeRepo,
                          StockIngredientRepo stockRepo) {
        this.productRepo = productRepo;
        this.ingredientRepo = ingredientRepo;
        this.recipeRepo = recipeRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public void run(String... args) {

        //  INGREDIENTES
        Ingredient pan = crearIngredienteSiNoExiste("Pan", "unidades");
        Ingredient carne = crearIngredienteSiNoExiste("Carne", "kg");
        Ingredient queso = crearIngredienteSiNoExiste("Queso", "rebanadas");
        Ingredient lechuga = crearIngredienteSiNoExiste("Lechuga", "kg");
        Ingredient tomate = crearIngredienteSiNoExiste("Tomate", "kg");
        Ingredient patata = crearIngredienteSiNoExiste("Patata", "kg");
        Ingredient aceite = crearIngredienteSiNoExiste("Aceite", "litros");

        //  STOCK (current, max, min)
        crearStockSiNoExiste(pan, 50.0, 100.0, 5.0, LocalDate.now().plusDays(7));
        crearStockSiNoExiste(carne, 20.0, 50.0, 2.0, LocalDate.now().plusDays(5));
        crearStockSiNoExiste(queso, 30.0, 60.0, 3.0, LocalDate.now().plusDays(10));
        crearStockSiNoExiste(lechuga, 10.0, 30.0, 1.0, LocalDate.now().plusDays(4));
        crearStockSiNoExiste(tomate, 10.0, 30.0, 1.0, LocalDate.now().plusDays(4));
        crearStockSiNoExiste(patata, 15.0, 40.0, 2.0, LocalDate.now().plusDays(10));
        crearStockSiNoExiste(aceite, 5.0, 20.0, 1.0, LocalDate.now().plusDays(30));

        //  PRODUCTOS
        Product cheeseBurger = crearProductoSiNoExiste(
                "Cheese Burger", 8.5,
                "Hamburguesa con queso, lechuga y tomate", true
        );

        Product frenchFries = crearProductoSiNoExiste(
                "Patatas Fritas", 3.5,
                "Patatas fritas crujientes", true
        );

        // RECETAS
        crearRecipeSiNoExiste(cheeseBurger, pan, 1.0);
        crearRecipeSiNoExiste(cheeseBurger, carne, 0.15);
        crearRecipeSiNoExiste(cheeseBurger, queso, 1.0);
        crearRecipeSiNoExiste(cheeseBurger, lechuga, 0.02);
        crearRecipeSiNoExiste(cheeseBurger, tomate, 0.03);

        crearRecipeSiNoExiste(frenchFries, patata, 0.25);
        crearRecipeSiNoExiste(frenchFries, aceite, 0.05);

        System.out.println("✔ Datos de prueba creados correctamente.");
    }

    // -------------------- MÉTODOS AUXILIARES --------------------

    private Ingredient crearIngredienteSiNoExiste(String nombre, String unidad) {
        return ingredientRepo.findAll().stream()
                .filter(i -> i.getName().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseGet(() -> {
                    Ingredient ing = new Ingredient();
                    ing.setName(nombre);
                    ing.setUnit(unidad);
                    ingredientRepo.save(ing);
                    return ing;
                });
    }

    private void crearStockSiNoExiste(Ingredient ing,
                                      double currentStock,
                                      double maxStock,
                                      double minStock,
                                      LocalDate expiration) {

        if (stockRepo.findById(ing.getId()).isEmpty()) {

            StockIngredient stock = new StockIngredient();
            stock.setIngredient(ing);

            stock.setCurrentStock(currentStock); // 🔥 CLAVE
            stock.setMaxStock(maxStock);
            stock.setMinStock(minStock);
            stock.setExpirationDate(expiration);

            stockRepo.save(stock);
        }
    }

    private Product crearProductoSiNoExiste(String nombre, double precio, String desc, boolean visible) {
        return productRepo.findAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseGet(() -> {
                    Product p = new Product();
                    p.setName(nombre);
                    p.setPrice(precio);
                    p.setDescription(desc);
                    p.setVisible(visible);
                    productRepo.save(p);
                    return p;
                });
    }

    private void crearRecipeSiNoExiste(Product product, Ingredient ingredient, double cantidad) {
        RecipeId id = new RecipeId(product.getId(), ingredient.getId());

        if (recipeRepo.findById(id).isEmpty()) {
            Recipe recipe = new Recipe();
            recipe.setId(id);
            recipe.setProduct(product);
            recipe.setIngredient(ingredient);
            recipe.setQuantity(cantidad);
            recipeRepo.save(recipe);
        }
    }
}