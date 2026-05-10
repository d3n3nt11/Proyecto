import type { IIngredient, IProducto } from "../types/Interfaces"; 
import { productosList } from "./data";
import { ingredientesList } from "./dataIngredientes";

const USAR_DATOS_LOCALES = false; 
const BASE_URL = "http://localhost:8081/api"; 



export interface BatchReplenishmentDTO {
    ingredientId: number;
    quantity: number;
    expirationDate: string; // formato YYYY-MM-DD
    batchNumber?: string;   // opcional
}

export async function peticionApi(url: string, options?: RequestInit) {
    try {
        const token = localStorage.getItem("token"); // Recupera JWT para autenticación
        
        const respuesta = await fetch(url, {
            ...options,
            headers: {
                "Content-Type": "application/json",
                ...(token && { Authorization: `Bearer ${token}` }), // Adjunta token si existe
                ...options?.headers, // Permite sobrescribir headers si es necesario
            },
        });

        if (!respuesta.ok) { 
            const errorText = await respuesta.text();
            throw new Error(errorText || `Error HTTP ${respuesta.status}`);
        }

        if (respuesta.status === 204) return null; 
        
        return respuesta.json(); 
        
    } catch (error) {
        console.error("Error en la petición API:", error); 
        throw error; 
    }
}

// Autentica usuario y retorna token + datos de sesión
export function login(data: { name: string; password: string }) {
    return peticionApi(`${BASE_URL}/auth/login`, {
        method: "POST",
        body: JSON.stringify(data),
    });
}

// Obtiene lista de ingredientes: API 
export async function getIngredientes(): Promise<IIngredient[]> {
    if (USAR_DATOS_LOCALES) {
        console.log("Usando datos locales");
        return ingredientesList;
    }
    return peticionApi(`${BASE_URL}/stock`);
}

// FUNCIONES DE PRODUCTOS
// Obtiene todos los producto 
export async function getAllProductos(): Promise<IProducto[]> {
    if (USAR_DATOS_LOCALES) {
        console.log("Usando datos locales");
        return productosList;
    }
    return peticionApi(`${BASE_URL}/products`);
}

// Filtra productos por categoría
export async function getProductosByCategoria(categoria: string): Promise<IProducto[]> {
    if (USAR_DATOS_LOCALES) {
        console.log(`Filtrando localmente: ${categoria}`);
        return productosList.filter((p) => 
            p.category?.toLowerCase() === categoria.toLowerCase()
        );
    }
    // Filtrado en cliente tras obtener todos los productos
    const productos = await peticionApi(`${BASE_URL}/products`);
    return productos.filter((p: IProducto) => 
        p.category?.toLowerCase() === categoria.toLowerCase()
    );
}

// Segun la categoría, se cogen unos datos o otros
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

// Obtiene datos del usuario autenticado
export function getMe() {
    return peticionApi(`${BASE_URL}/users/me`);
}


export function reponerInvenatario(ingredienteId: number, nuevoStock: number) {
    return peticionApi(
        `${BASE_URL}/stock/${ingredienteId}?newStock=${nuevoStock}&checkMin=false`,
        {
            method: "PUT",
        }
    );
}


export function reponerInventarioBatch(data: BatchReplenishmentDTO) {
    return peticionApi(`${BASE_URL}/stock/batch`, {
        method: "POST",
        body: JSON.stringify({
            ingredientId: data.ingredientId,
            quantity: data.quantity,
            expirationDate: data.expirationDate,
            batchNumber: data.batchNumber || null,
        }),
    });
}


export function modificarInventario(ingredienteId: number, nuevoPorcentaje: number) {
    return peticionApi(
        `${BASE_URL}/stock/${ingredienteId}/min-stock?minStock=${nuevoPorcentaje}`,
        { method: "PATCH" }
    );
}

// REPORTES / DESCARGAS
// Descarga informe de ventas en formato CSV binario
export async function descargarInformeCSV(start: string, end: string) {
    const token = localStorage.getItem("token");
    const response = await fetch(
        `${BASE_URL}/reports/sales/csv?start=${start}&end=${end}`,
        {
            method: "GET",
            headers: { ...(token && { Authorization: `Bearer ${token}` }) },
        }
    );
    if (!response.ok) throw new Error("Error al descargar el informe");
    return response.blob();
}
// Descarga reporte de movimientos de stock en CSV binario
export async function descargarStockMovements(start: string, end: string) {
    const token = localStorage.getItem("token");
    const response = await fetch(
        `${BASE_URL}/reports/stock-movements/csv?start=${start}&end=${end}`,
        { method: "GET", headers: { ...(token && { Authorization: `Bearer ${token}` }) } }
    );
    return response.blob();
}

// Obtiene ventas en JSON 
export function getVentasPorFechas(start: string, end: string) {
    return peticionApi(`${BASE_URL}/reports/sales?start=${start}&end=${end}`);
}


// Obtiene el consumo de ingredientes en JSON para visualizar en la app

export function getConsumoIngredientes(start: string, end: string) {
    return peticionApi(`${BASE_URL}/reports/ingredients-consumption/csv?start=${start}&end=${end}`);
}


// Obtiene movimientos de stock en JSON para visualizar en la app

export function getStockMovementsPorFechas(start: string, end: string) {
    return peticionApi(`${BASE_URL}/reports/stock-movimientos?start=${start}&end=${end}`);
}