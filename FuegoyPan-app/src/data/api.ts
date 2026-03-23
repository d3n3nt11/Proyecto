import type { IProducto } from "../types/Interfaces";

const BASE_URL = "http://localhost:8081/api";

// Función helper para hacer peticiones HTTP
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

        // Si la respuesta no es OK, lanzamos error
        if (!respuesta.ok) {
            throw new Error(`Error en el inicio de sesion`);
        }

        // Si es 204, retornamos null
        if (respuesta.status === 204) {
            return null;
        }
        
        // Devolvemos los datos como JSON
        return respuesta.json();
        
    } catch (error) {
        console.error("Error en la petición API:", error);
        throw error; 
    }
}

export function login(data: { name: string; password: string }) {
    return peticionApi(`${BASE_URL}/auth/login`, {method: "POST",body: JSON.stringify(data),  });
}

export async function getAllProductos(): Promise<IProducto[]> {
    return peticionApi(`${BASE_URL}/products`);
}

export async function getProductosByCategoria(categoria: string): Promise<IProducto[]> {
    const productos = await getAllProductos();
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
    return peticionApi(`${BASE_URL}/users/me`);
}

