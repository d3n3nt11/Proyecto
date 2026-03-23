import React, { useEffect, useState } from "react";
import CardFood from "../Components/CardFood";
import { getAllProductos, getHamburguesas } from "../data/api";
import type { IProducto } from "../types/Interfaces";

export default function Burger() {

  const uid = React.useId(); // Genera un ID único para este componente
  const [productos, setProductos] = React.useState<IProducto[]>([]);
  const [loading, setLoading] = React.useState(true);
  const[search, setSearch] = useState<string>("");

  useEffect(() => {
    if(search.trim() === "") {
      setProductos(productos);
      return;
    }else {
      const productosFiltrados = productos.filter((producto) =>
        producto.name.toLowerCase().includes(search.toLowerCase())
      );
      setProductos(productosFiltrados);
    }

  }, [search, productos]);

  useEffect(() => {
    const cargarHamburguesas = async () => {
      try {
        const data = await getAllProductos();
        setProductos(data);
      } catch (error) {
        console.error("Error al cargar hamburguesas:", error);
      } finally {
        setLoading(false);
      }
    };
    cargarHamburguesas();
  }, []); 

  return (
    <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center justify-start py-10">
      <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
      <h1 className="text-2xl text-white font-bold">¿Qué desea el cliente?</h1>
      <input
        type="text"
        placeholder="Buscar hamburguesa..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        className="mt-4 p-2 rounded-md border border-gray-300 focus:outline-none focus:ring-2 focus:ring-blue-500"
      />
        {loading && (
          <p className="text-gray-600">Cargando productos...</p>
        )}
        {!loading && (
          <div className="grid grid-cols-4 gap-5 mt-5">
              {productos.map((producto) => (
                  <CardFood
                      key={`${uid}-${producto.id}`} 
                      name={producto.name}
                      description={producto.description}
                      price={producto.price}
                      category={producto.category}
                      imageUrl={producto.imageUrl}
                  />
              ))}
          </div>
        )}
        {!loading && productos.length === 0 && (
          <p className="text-gray-500">No hay productos disponibles</p>
        )}
    </div>
  )
}
