import { peticionApi } from "../data/api";

const BASE_URL = "http://localhost:8081/api/sales";

// Crear venta
export function createSale(data: any) {
  return peticionApi(BASE_URL, {
    method: "POST",
    body: JSON.stringify(data),
  });
}

// Obtener todas
export function getAllSales() {
  return peticionApi(BASE_URL);
}

// Obtener por ID
export function getSaleById(id: number) {
  return peticionApi(`${BASE_URL}/${id}`);
}

// Cambiar estado
export function updateSaleStatus(id: number, status: string) {
  return peticionApi(`${BASE_URL}/${id}/status`, {
    method: "PATCH",
    body: JSON.stringify({ status }),
  });
}

// Cancelar venta
export function cancelSale(id: number) {
  return peticionApi(`${BASE_URL}/${id}/cancel`, {
    method: "PATCH",
  });
}

export function paySale(id: number) {
  return peticionApi(`${BASE_URL}/${id}/pay`, {
    method: "POST",
  });
}