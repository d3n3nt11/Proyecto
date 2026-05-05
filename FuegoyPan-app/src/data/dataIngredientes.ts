import type { IIngredient } from "../types/Interfaces";

// ============================================
export const ingredientesList: IIngredient[] = [
    // INGREDIENTES PARA HAMBURGUESAS
    {
        ingredientId: 1,
        ingredientName: "Pan de hamburguesa",
        currentStock: 45,
        unit: "Uds",
        minStock: 10,
        expirationDate: "2026-04-15",
        image: "https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=400"
    },
    {
        ingredientId: 2,
        ingredientName: "Carne de ternera",
        currentStock: 12.5,
        unit: "kg",
        minStock: 2,
        expirationDate: "2026-04-10",
        image: "https://images.unsplash.com/photo-1603048297172-c92544798d5e?w=400"
    },
    {
        ingredientId: 3,
        ingredientName: "Queso cheddar",
        currentStock: 3.2,
        unit: "kg",
        minStock: 1,
        expirationDate: "2026-04-20",
        image: "https://images.unsplash.com/photo-1618164436241-4473940d4fdc?w=400"
    },
    {
        ingredientId: 4,
        ingredientName: "Lechuga",
        currentStock: 2.8,
        unit: "kg",
        minStock: 1,
        expirationDate: "2026-04-12",
        image: "https://images.unsplash.com/photo-1622206151226-18ca2c9ab4a1?w=400"
    },
    {
        ingredientId: 5,
        ingredientName: "Tomate",
        currentStock: 4.1,
        unit: "kg",
        minStock: 1.5,
        expirationDate: "2026-04-11",
        image: "https://images.unsplash.com/photo-1592924357228-91a4daadc420?w=400"
    },
    {
        ingredientId: 6,
        ingredientName: "Cebolla",
        currentStock: 3.5,
        unit: "kg",
        minStock: 1,
        expirationDate: "2026-04-18",
        image: "https://images.unsplash.com/photo-1618512496248-a07fe83aa8cb?w=400"
    },
    {
        ingredientId: 7,
        ingredientName: "Bacon",
        currentStock: 2.0,
        unit: "kg",
        minStock: 0.5,
        expirationDate: "2026-04-14",
        image: "https://images.unsplash.com/photo-1529692236671-f1f6cf9683ba?w=400"
    },
    {
        ingredientId: 8,
        ingredientName: "Salsa especial",
        currentStock: 1.8,
        unit: "L",
        minStock: 0.5,
        expirationDate: "2026-05-01",
        image: "https://images.unsplash.com/photo-1563205764-6cfc70ee6025?w=400"
    },
    {
        ingredientId: 9,
        ingredientName: "Medallón vegetal",
        currentStock: 18,
        unit: "Uds",
        minStock: 5,
        expirationDate: "2026-04-13",
        image: "https://images.unsplash.com/photo-1550317138-100011a4c5db?w=400"
    },
    {
        ingredientId: 10,
        ingredientName: "Aguacate",
        currentStock: 12,
        unit: "Uds",
        minStock: 4,
        expirationDate: "2026-04-10",
        image: "https://images.unsplash.com/photo-1523049673856-64842a6e9e8b?w=400"
    },

    // INGREDIENTES PARA GUARNICIONES
    {
        ingredientId: 11,
        ingredientName: "Patata para fritas",
        currentStock: 25.0,
        unit: "kg",
        minStock: 5,
        expirationDate: "2026-04-25",
        image: "https://images.unsplash.com/photo-1518977676601-b53f82aba655?w=400"
    },
    {
        ingredientId: 12,
        ingredientName: "Aceite de girasol",
        currentStock: 8.5,
        unit: "L",
        minStock: 2,
        expirationDate: "2026-06-30",
        image: "https://images.unsplash.com/photo-1474979266404-7eaacbcd87c5?w=400"
    },
    {
        ingredientId: 13,
        ingredientName: "Sal marina",
        currentStock: 2.0,
        unit: "kg",
        minStock: 0.5,
        expirationDate: "2027-01-01",
        image: "https://images.unsplash.com/photo-1599909687489-80b5c5f8a6d8?w=400"
    },
    {
        ingredientId: 14,
        ingredientName: "Rebozado para nuggets",
        currentStock: 3.5,
        unit: "kg",
        minStock: 1,
        expirationDate: "2026-05-15",
        image: "https://images.unsplash.com/photo-1604908176997-12e856cf7a4c?w=400"
    },
    {
        ingredientId: 15,
        ingredientName: "Pechuga de pollo",
        currentStock: 8.2,
        unit: "kg",
        minStock: 2,
        expirationDate: "2026-04-11",
        image: "https://images.unsplash.com/photo-1604503468506-a8da134df2ad?w=400"
    },

    // INGREDIENTES PARA ENSALADAS
    {
        ingredientId: 16,
        ingredientName: "Rúcula",
        currentStock: 1.2,
        unit: "kg",
        minStock: 0.5,
        expirationDate: "2026-04-10",
        image: "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=400"
    },
    {
        ingredientId: 17,
        ingredientName: "Queso parmesano",
        currentStock: 0.8,
        unit: "kg",
        minStock: 0.3,
        expirationDate: "2026-05-20",
        image: "https://images.unsplash.com/photo-1618164436241-4473940d4fdc?w=400"
    },
    {
        ingredientId: 18,
        ingredientName: "Croutons",
        currentStock: 1.5,
        unit: "kg",
        minStock: 0.5,
        expirationDate: "2026-04-30",
        image: "https://images.unsplash.com/photo-1579888949390-23a1eec5ed6f?w=400"
    },
    {
        ingredientId: 19,
        ingredientName: "Salsa césar",
        currentStock: 2.2,
        unit: "L",
        minStock: 0.5,
        expirationDate: "2026-04-25",
        image: "https://images.unsplash.com/photo-1563205764-6cfc70ee6025?w=400"
    },

    // SALSAS Y CONDIMENTOS
    {
        ingredientId: 20,
        ingredientName: "Ketchup",
        currentStock: 4.5,
        unit: "L",
        minStock: 1,
        expirationDate: "2026-08-01",
        image: "https://images.unsplash.com/photo-1624823183969-1c4f5b8f8c8e?w=400"
    },
    {
        ingredientId: 21,
        ingredientName: "Mostaza",
        currentStock: 3.8,
        unit: "L",
        minStock: 1,
        expirationDate: "2026-07-15",
        image: "https://images.unsplash.com/photo-1590490360182-c31938a86497?w=400"
    },
    {
        ingredientId: 22,
        ingredientName: "Salsa barbacoa",
        currentStock: 2.1,
        unit: "L",
        minStock: 0.5,
        expirationDate: "2026-06-20",
        image: "https://images.unsplash.com/photo-1631515243349-e0cbe4c3f6b5?w=400"
    },
    {
        ingredientId: 23,
        ingredientName: "Salsa ranch",
        currentStock: 1.9,
        unit: "L",
        minStock: 0.5,
        expirationDate: "2026-04-22",
        image: "https://images.unsplash.com/photo-1606312619070-7f3a4f2c9f3e?w=400"
    },
    {
        ingredientId: 24,
        ingredientName: "Salsa picante",
        currentStock: 1.2,
        unit: "L",
        minStock: 0.3,
        expirationDate: "2026-09-01",
        image: "https://images.unsplash.com/photo-1563240670-a7c7fac1b778?w=400"
    },
    {
        ingredientId: 25,
        ingredientName: "Queso fundingredientIdo",
        currentStock: 2.5,
        unit: "L",
        minStock: 0.5,
        expirationDate: "2026-04-18",
        image: "https://images.unsplash.com/photo-1628103228494-2f68f1e98c0b?w=400"
    },

    // INGREDIENTES PARA POSTRES
    {
        ingredientId: 26,
        ingredientName: "Chocolate para brownie",
        currentStock: 3.0,
        unit: "kg",
        minStock: 1,
        expirationDate: "2026-12-01",
        image: "https://images.unsplash.com/photo-1548907040-4f3805db4532?w=400"
    },
    {
        ingredientId: 27,
        ingredientName: "Harina de trigo",
        currentStock: 15.0,
        unit: "kg",
        minStock: 5,
        expirationDate: "2027-01-15",
        image: "https://images.unsplash.com/photo-1509440159596-0249088772ff?w=400"
    },
];