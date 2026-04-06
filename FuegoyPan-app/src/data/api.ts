import type { IProducto } from "../types/Interfaces";
import { productosList } from "./data";

// CAMBIA ESTO A false CUANDO TENGAS LA API LISTA
const USAR_DATOS_LOCALES = true;

const BASE_URL = "http://localhost:8081/api";

async function peticionApi(url: string, options?: any) {
    try {
        const token = localStorage.getItem("token");
        
        const respuesta = await fetch(url, {
            headers: {
                "Content-Type": "application/json",
                ...(token && { Authorization: `Bearer ${token}` }),
                ...options?.headers,
            },
            ...options,
        });

        if (!respuesta.ok) {
            throw new Error(`Error en el inicio de sesion`);
        }

        if (respuesta.status === 204) {
            return null;
        }
        
        return respuesta.json();
        
    } catch (error) {
        console.error("Error en la petición API:", error);
        throw error; 
    }
}

export function login(data: { name: string; password: string }) {
    return peticionApi(`${BASE_URL}/auth/login`, {
        method: "POST",
        body: JSON.stringify(data),
    });
}

// FUNCIONES DE PRODUCTOS

export async function getAllProductos(): Promise<IProducto[]> {
    if (USAR_DATOS_LOCALES) {
        console.log("Usando datos locales");
        return productosList;
    }
    return peticionApi(`${BASE_URL}/products`);
}

export async function getProductosByCategoria(categoria: string): Promise<IProducto[]> {
    if (USAR_DATOS_LOCALES) {
        console.log(`Filtrando localmente: ${categoria}`);
        return productosList.filter((p) => 
            p.category?.toLowerCase() === categoria.toLowerCase()
        );
    }
    const productos = await peticionApi(`${BASE_URL}/products`);
    return productos.filter((p: IProducto) => 
        p.category?.toLowerCase() === categoria.toLowerCase()
    );
}

export function getHamburguesas(): Promise<IProducto[]> {
    return getProductosByCategoria("comida");
}

export function getBebidas(): Promise<IProducto[]> {
    return getProductosByCategoria("bebida");
}

export function getSalsas(): Promise<IProducto[]> {
    return getProductosByCategoria("salsa");
}

export function getPostres(): Promise<IProducto[]> {
    return getProductosByCategoria("postre");
}

export function getMe() {
    // getMe siempre va a la API 
    return peticionApi(`${BASE_URL}/users/me`);
}