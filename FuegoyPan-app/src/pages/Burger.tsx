import React, { useEffect, useState } from "react";
import CardFood from "../Components/CardFood";
import { getHamburguesas } from "../data/api";
import type { IProducto } from "../types/Interfaces";
import MenuCategoria from "../Components/MenuCategoria";
import SubNavegacion from "../Components/SubNavegacion";
import { useCart } from "../context/cartContext";


export default function Burger() {

  const uid = React.useId();

  const { addToCart } = useCart(); //  CART GLOBAL

  const [productos, setProductos] = useState<IProducto[]>([]);
  const [loading, setLoading] = useState(true);
  const [search, setSearch] = useState("");
  const [filteredHamburguesas, setFilteredHamburguesas] = useState<IProducto[]>([]);

  // cargar hamburguesas
  useEffect(() => {
    const cargarComida = async () => {
      try {
        const data = await getHamburguesas();
        setProductos(data);
      } catch (error) {
        console.error("Error:", error);
      } finally {
        setLoading(false);
      }
    };

    cargarComida();
  }, []);

  //  buscador
  useEffect(() => {
    if (search.trim() === "") {
      setFilteredHamburguesas(productos);
    } else {
      const filtered = productos.filter((p) =>
        p.name.toLowerCase().includes(search.toLowerCase())
      );
      setFilteredHamburguesas(filtered);
    }
  }, [search, productos]);

  return (
    <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">

      <img
        src="src/assets/logo.png"
        alt="logo"
        className="w-75 h-45 rounded-full"
      />

      <h1 className="text-2xl text-white font-bold mb-4">
        ¿Qué desea el cliente?
      </h1>

      {/*  SEARCH */}
      <div className="relative mt-4 w-64">
        <input
          type="text"
          placeholder="Buscar producto..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          className="w-full pl-4 pr-4 py-2 text-gray-700 rounded-md bg-gray-300 border border-gray-300 focus:outline-none focus:ring-2 focus:ring-red-500"
        />
      </div>

      <MenuCategoria />

      {loading && (
        <p className="text-gray-600 mt-4">Cargando...</p>
      )}

      {!loading && (
        <div className="grid grid-cols-4 gap-5 p-4 mt-5">

          {filteredHamburguesas.map((producto) => (
            <CardFood
              key={`${uid}-${producto.id}`}
              data={producto}
              onAdd={(p) => addToCart(p)} // Aquí se añade al carrito
            />
          ))}

        </div>
      )}

      {!loading && filteredHamburguesas.length === 0 && (
        <p className="text-gray-500 mt-4">
          No hay productos disponibles
        </p>
      )}

      <SubNavegacion />
    </div>
  );
}