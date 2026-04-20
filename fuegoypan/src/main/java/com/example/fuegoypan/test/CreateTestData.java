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

        // ---------------- INGREDIENTES ----------------
        Ingredient pan = crearIngredienteSiNoExiste("Pan", "unidades");
        Ingredient carne = crearIngredienteSiNoExiste("Carne", "kg");
        Ingredient queso = crearIngredienteSiNoExiste("Queso", "rebanadas");
        Ingredient lechuga = crearIngredienteSiNoExiste("Lechuga", "kg");
        Ingredient tomate = crearIngredienteSiNoExiste("Tomate", "kg");
        Ingredient patata = crearIngredienteSiNoExiste("Patata", "kg");
        Ingredient aceite = crearIngredienteSiNoExiste("Aceite", "litros");
        Ingredient leche = crearIngredienteSiNoExiste("Leche", "litros");
        Ingredient chocolate = crearIngredienteSiNoExiste("Chocolate", "kg");
        Ingredient azucar = crearIngredienteSiNoExiste("Azúcar", "kg");
        Ingredient agua = crearIngredienteSiNoExiste("Agua", "litros");

        // ---------------- STOCK ----------------
        crearStockSiNoExiste(pan, 50.0, 100.0, 5.0, LocalDate.now().plusDays(7));
        crearStockSiNoExiste(carne, 20.0, 50.0, 2.0, LocalDate.now().plusDays(5));
        crearStockSiNoExiste(queso, 30.0, 60.0, 3.0, LocalDate.now().plusDays(10));
        crearStockSiNoExiste(lechuga, 10.0, 30.0, 1.0, LocalDate.now().plusDays(4));
        crearStockSiNoExiste(tomate, 10.0, 30.0, 1.0, LocalDate.now().plusDays(4));
        crearStockSiNoExiste(patata, 15.0, 40.0, 2.0, LocalDate.now().plusDays(10));
        crearStockSiNoExiste(aceite, 5.0, 20.0, 1.0, LocalDate.now().plusDays(30));
        crearStockSiNoExiste(leche, 10.0, 25.0, 2.0, LocalDate.now().plusDays(6));
        crearStockSiNoExiste(chocolate, 8.0, 20.0, 1.0, LocalDate.now().plusDays(90));
        crearStockSiNoExiste(azucar, 12.0, 30.0, 2.0, LocalDate.now().plusDays(365));
        crearStockSiNoExiste(agua, 50.0, 200.0, 10.0, LocalDate.now().plusDays(30));

        // ---------------- PRODUCTOS ----------------

        // 🍔 COMIDA
        Product burger = crearProductoSiNoExiste(
                "Cheese Burger",
                8.5,
                "Hamburguesa con queso, lechuga y tomate",
                true,
                Category.comida
        );

        Product fries = crearProductoSiNoExiste(
                "Patatas Fritas",
                3.5,
                "Patatas fritas crujientes",
                true,
                Category.comida
        );

        // 🥤 BEBIDA
        Product cola = crearProductoSiNoExiste(
                "Coca Cola",
                2.5,
                "Bebida refrescante con gas",
                true,
                Category.bebida
        );

        Product water = crearProductoSiNoExiste(
                "Agua",
                1.5,
                "Agua mineral",
                true,
                Category.bebida
        );

        // 🍰 POSTRE
        Product cake = crearProductoSiNoExiste(
                "Tarta de Chocolate",
                4.5,
                "Postre de chocolate",
                true,
                Category.postre
        );

        Product iceCream = crearProductoSiNoExiste(
                "Helado de Vainilla",
                3.0,
                "Helado cremoso",
                true,
                Category.postre
        );

        // 🧂 SALSAS
        Product ketchup = crearProductoSiNoExiste(
                "Ketchup",
                0.5,
                "Salsa de tomate",
                true,
                Category.salsa
        );

        Product mayo = crearProductoSiNoExiste(
                "Mayonesa",
                0.5,
                "Salsa cremosa",
                true,
                Category.salsa
        );

        // ---------------- RECETAS ----------------

        // BURGER
        crearRecipeSiNoExiste(burger, pan, 1.0);
        crearRecipeSiNoExiste(burger, carne, 0.15);
        crearRecipeSiNoExiste(burger, queso, 1.0);
        crearRecipeSiNoExiste(burger, lechuga, 0.02);
        crearRecipeSiNoExiste(burger, tomate, 0.03);

        // FRIES
        crearRecipeSiNoExiste(fries, patata, 0.25);
        crearRecipeSiNoExiste(fries, aceite, 0.05);

        // CAKE
        crearRecipeSiNoExiste(cake, chocolate, 0.2);
        crearRecipeSiNoExiste(cake, leche, 0.3);
        crearRecipeSiNoExiste(cake, azucar, 0.1);

        // ICE CREAM
        crearRecipeSiNoExiste(iceCream, leche, 0.5);
        crearRecipeSiNoExiste(iceCream, azucar, 0.08);

        System.out.println("✔ Datos de restaurante creados correctamente.");
    }

    // ---------------- INGREDIENTES ----------------
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

    // ---------------- STOCK ----------------
    private void crearStockSiNoExiste(Ingredient ing,
                                      double currentStock,
                                      double maxStock,
                                      double minStock,
                                      LocalDate expiration) {

        if (stockRepo.findById(ing.getId()).isEmpty()) {

            StockIngredient stock = new StockIngredient();
            stock.setIngredient(ing);
            stock.setCurrentStock(currentStock);
            stock.setMaxStock(maxStock);
            stock.setMinStock(minStock);
            stock.setExpirationDate(expiration);

            stockRepo.save(stock);
        }
    }

    // ---------------- PRODUCTOS ----------------
    private Product crearProductoSiNoExiste(String nombre,
                                            double precio,
                                            String desc,
                                            boolean visible,
                                            Category category) {

        return productRepo.findAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseGet(() -> {
                    Product p = new Product();
                    p.setName(nombre);
                    p.setPrice(precio);
                    p.setDescription(desc);
                    p.setVisible(visible);
                    p.setCategory(category);
                    p.setImageUrl(null);

                    productRepo.save(p);
                    return p;
                });
    }

    // ---------------- RECETAS ----------------
    private void crearRecipeSiNoExiste(Product product, Ingredient ingredient, double cantidad) {

        boolean exists = recipeRepo
                .findByProductIdAndIngredientId(product.getId(), ingredient.getId())
                .isPresent();

        if (!exists) {
            Recipe recipe = new Recipe();
            recipe.setProduct(product);
            recipe.setIngredient(ingredient);
            recipe.setQuantity(cantidad);

            recipeRepo.save(recipe);
        }
    }
}