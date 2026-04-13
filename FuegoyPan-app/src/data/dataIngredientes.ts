import type { IIngrediente } from "../types/Interfaces";

// ============================================
export const ingredientesList: IIngrediente[] = [
    // INGREDIENTES PARA HAMBURGUESAS
    {
        id: 1,
        nombre: "Pan de hamburguesa",
        cantidad: 45,
        unidad: "Uds",
        minimo: 10,
        caducidad: "2026-04-15",
        imageUrl: "https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=400"
    },
    {
        id: 2,
        nombre: "Carne de ternera",
        cantidad: 12.5,
        unidad: "kg",
        minimo: 2,
        caducidad: "2026-04-10",
        imageUrl: "https://images.unsplash.com/photo-1603048297172-c92544798d5e?w=400"
    },
    {
        id: 3,
        nombre: "Queso cheddar",
        cantidad: 3.2,
        unidad: "kg",
        minimo: 1,
        caducidad: "2026-04-20",
        imageUrl: "https://images.unsplash.com/photo-1618164436241-4473940d4fdc?w=400"
    },
    {
        id: 4,
        nombre: "Lechuga",
        cantidad: 2.8,
        unidad: "kg",
        minimo: 1,
        caducidad: "2026-04-12",
        imageUrl: "https://images.unsplash.com/photo-1622206151226-18ca2c9ab4a1?w=400"
    },
    {
        id: 5,
        nombre: "Tomate",
        cantidad: 4.1,
        unidad: "kg",
        minimo: 1.5,
        caducidad: "2026-04-11",
        imageUrl: "https://images.unsplash.com/photo-1592924357228-91a4daadc420?w=400"
    },
    {
        id: 6,
        nombre: "Cebolla",
        cantidad: 3.5,
        unidad: "kg",
        minimo: 1,
        caducidad: "2026-04-18",
        imageUrl: "https://images.unsplash.com/photo-1618512496248-a07fe83aa8cb?w=400"
    },
    {
        id: 7,
        nombre: "Bacon",
        cantidad: 2.0,
        unidad: "kg",
        minimo: 0.5,
        caducidad: "2026-04-14",
        imageUrl: "https://images.unsplash.com/photo-1529692236671-f1f6cf9683ba?w=400"
    },
    {
        id: 8,
        nombre: "Salsa especial",
        cantidad: 1.8,
        unidad: "L",
        minimo: 0.5,
        caducidad: "2026-05-01",
        imageUrl: "https://images.unsplash.com/photo-1563205764-6cfc70ee6025?w=400"
    },
    {
        id: 9,
        nombre: "Medallón vegetal",
        cantidad: 18,
        unidad: "Uds",
        minimo: 5,
        caducidad: "2026-04-13",
        imageUrl: "https://images.unsplash.com/photo-1550317138-100011a4c5db?w=400"
    },
    {
        id: 10,
        nombre: "Aguacate",
        cantidad: 12,
        unidad: "Uds",
        minimo: 4,
        caducidad: "2026-04-10",
        imageUrl: "https://images.unsplash.com/photo-1523049673856-64842a6e9e8b?w=400"
    },

    // INGREDIENTES PARA GUARNICIONES
    {
        id: 11,
        nombre: "Patata para fritas",
        cantidad: 25.0,
        unidad: "kg",
        minimo: 5,
        caducidad: "2026-04-25",
        imageUrl: "https://images.unsplash.com/photo-1518977676601-b53f82aba655?w=400"
    },
    {
        id: 12,
        nombre: "Aceite de girasol",
        cantidad: 8.5,
        unidad: "L",
        minimo: 2,
        caducidad: "2026-06-30",
        imageUrl: "https://images.unsplash.com/photo-1474979266404-7eaacbcd87c5?w=400"
    },
    {
        id: 13,
        nombre: "Sal marina",
        cantidad: 2.0,
        unidad: "kg",
        minimo: 0.5,
        caducidad: "2027-01-01",
        imageUrl: "https://images.unsplash.com/photo-1599909687489-80b5c5f8a6d8?w=400"
    },
    {
        id: 14,
        nombre: "Rebozado para nuggets",
        cantidad: 3.5,
        unidad: "kg",
        minimo: 1,
        caducidad: "2026-05-15",
        imageUrl: "https://images.unsplash.com/photo-1604908176997-12e856cf7a4c?w=400"
    },
    {
        id: 15,
        nombre: "Pechuga de pollo",
        cantidad: 8.2,
        unidad: "kg",
        minimo: 2,
        caducidad: "2026-04-11",
        imageUrl: "https://images.unsplash.com/photo-1604503468506-a8da134df2ad?w=400"
    },

    // INGREDIENTES PARA ENSALADAS
    {
        id: 16,
        nombre: "Rúcula",
        cantidad: 1.2,
        unidad: "kg",
        minimo: 0.5,
        caducidad: "2026-04-10",
        imageUrl: "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=400"
    },
    {
        id: 17,
        nombre: "Queso parmesano",
        cantidad: 0.8,
        unidad: "kg",
        minimo: 0.3,
        caducidad: "2026-05-20",
        imageUrl: "https://images.unsplash.com/photo-1618164436241-4473940d4fdc?w=400"
    },
    {
        id: 18,
        nombre: "Croutons",
        cantidad: 1.5,
        unidad: "kg",
        minimo: 0.5,
        caducidad: "2026-04-30",
        imageUrl: "https://images.unsplash.com/photo-1579888949390-23a1eec5ed6f?w=400"
    },
    {
        id: 19,
        nombre: "Salsa césar",
        cantidad: 2.2,
        unidad: "L",
        minimo: 0.5,
        caducidad: "2026-04-25",
        imageUrl: "https://images.unsplash.com/photo-1563205764-6cfc70ee6025?w=400"
    },

    // SALSAS Y CONDIMENTOS
    {
        id: 20,
        nombre: "Ketchup",
        cantidad: 4.5,
        unidad: "L",
        minimo: 1,
        caducidad: "2026-08-01",
        imageUrl: "https://images.unsplash.com/photo-1624823183969-1c4f5b8f8c8e?w=400"
    },
    {
        id: 21,
        nombre: "Mostaza",
        cantidad: 3.8,
        unidad: "L",
        minimo: 1,
        caducidad: "2026-07-15",
        imageUrl: "https://images.unsplash.com/photo-1590490360182-c31938a86497?w=400"
    },
    {
        id: 22,
        nombre: "Salsa barbacoa",
        cantidad: 2.1,
        unidad: "L",
        minimo: 0.5,
        caducidad: "2026-06-20",
        imageUrl: "https://images.unsplash.com/photo-1631515243349-e0cbe4c3f6b5?w=400"
    },
    {
        id: 23,
        nombre: "Salsa ranch",
        cantidad: 1.9,
        unidad: "L",
        minimo: 0.5,
        caducidad: "2026-04-22",
        imageUrl: "https://images.unsplash.com/photo-1606312619070-7f3a4f2c9f3e?w=400"
    },
    {
        id: 24,
        nombre: "Salsa picante",
        cantidad: 1.2,
        unidad: "L",
        minimo: 0.3,
        caducidad: "2026-09-01",
        imageUrl: "https://images.unsplash.com/photo-1563240670-a7c7fac1b778?w=400"
    },
    {
        id: 25,
        nombre: "Queso fundido",
        cantidad: 2.5,
        unidad: "L",
        minimo: 0.5,
        caducidad: "2026-04-18",
        imageUrl: "https://images.unsplash.com/photo-1628103228494-2f68f1e98c0b?w=400"
    },

    // INGREDIENTES PARA POSTRES
    {
        id: 26,
        nombre: "Chocolate para brownie",
        cantidad: 3.0,
        unidad: "kg",
        minimo: 1,
        caducidad: "2026-12-01",
        imageUrl: "https://images.unsplash.com/photo-1548907040-4f3805db4532?w=400"
    },
    {
        id: 27,
        nombre: "Harina de trigo",
        cantidad: 15.0,
        unidad: "kg",
        minimo: 5,
        caducidad: "2027-01-15",
        imageUrl: "https://images.unsplash.com/photo-1509440159596-0249088772ff?w=400"
    },
];