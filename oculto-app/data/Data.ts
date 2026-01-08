import { IFood } from "@/types/Interfaces";
import { ICategory } from "@/types/Interfaces";


export const categories: ICategory[]=[
  {
    cat: 1,
    img: "",
  },
  {
    cat: 2,
    img: "",
  },
  {
    cat: 3,
    img: "",
  },
  {
    cat: 4,
    img: "",
  },



];




export const foodList: IFood[] = [
  // Categoría 1: Hamburguesas
  {
    cat: 1,
    name: "La Silenciosa",
    kcal: 680,
    icon: "https://cdn-icons-png.flaticon.com/512/6978/6978167.png",
  },
  {
    cat: 1,
    name: "El Ausente",
    kcal: 820,
    icon: "https://cdn-icons-png.flaticon.com/512/6978/6978167.png",
  },
  {
    cat: 1,
    name: "Confesión",
    kcal: 750,
    icon: "https://cdn-icons-png.flaticon.com/512/6978/6978167.png",
  },

  // Categoría 2: Acompañamientos
  {
    cat: 2,
    name: "Patatas del Olvido",
    kcal: 320,
    icon: "https://cdn-icons-png.flaticon.com/512/1531/1531385.png",
  },
  {
    cat: 2,
    name: "Aros de Cebolla",
    kcal: 280,
    icon: "https://cdn-icons-png.flaticon.com/512/3076/3076623.png",
  },
  {
    cat: 2,
    name: "Nuggets Secretos",
    kcal: 350,
    icon: "https://cdn-icons-png.flaticon.com/512/6978/6978167.png",
  },

  // Categoría 3: Bebidas
  {
    cat: 3,
    name: "Negra Confesión",
    kcal: 160,
    icon: "https://cdn-icons-png.flaticon.com/512/3420/3420382.png",
  },
  {
    cat: 3,
    name: "Agua Bendita",
    kcal: 0,
    icon: "https://cdn-icons-png.flaticon.com/512/1048/1048854.png",
  },
  {
    cat: 3,
    name: "Licor de la Verdad",
    kcal: 210,
    icon: "https://cdn-icons-png.flaticon.com/512/2991/2991152.png",
  },

  // Categoría 4: Postres / Extras
  {
    cat: 4,
    name: "Tarta del Silencio",
    kcal: 420,
    icon: "https://cdn-icons-png.flaticon.com/512/3216/3216637.png",
  },
  {
    cat: 4,
    name: "Helado Ausente",
    kcal: 290,
    icon: "https://cdn-icons-png.flaticon.com/512/3136/3136238.png",
  },
  {
    cat: 4,
    name: "Galleta de la Culpa",
    kcal: 180,
    icon: "https://cdn-icons-png.flaticon.com/512/9293/9293780.png",
  },
];