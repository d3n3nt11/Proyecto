import React, { useEffect, useState } from "react";
import CardFood from "../Components/CardFood";
import { getBebidas } from "../data/api";
import type { IProducto } from "../types/Interfaces";
import MenuCategoria from "../Components/MenuCategoria";
import SubNavegacion from "../Components/SubNavegacion";
import { useCart } from "../context/cartContext";

export default function Bebidas() {
    const uid = React.useId();
    const { addToCart } = useCart(); //  CART GLOBAL
    const [productos, setProductos] = useState<IProducto[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");
    const [filteredBebidas, setFilteredBebidas] = useState<IProducto[]>([]);

    // UseEffect para cargar las hamburguesas
    useEffect(() => {
        const cargarComida = async () => {
            try {
                const data = await getBebidas();
                setProductos(data);
            } catch (error) {
                console.error("Error:", error);
            } finally {
                setLoading(false);
            }
        };
        cargarComida();
    }, []);

    //Useeeffect para el buscador
    useEffect(() => {
        if (search.trim() === "") {
            setFilteredBebidas(productos);
        } else {
            const findBebidas = productos.filter((p) =>
            p.name.toLowerCase().includes(search.toLowerCase())
            );
            setFilteredBebidas(findBebidas);
        }
    }, [search, productos]);

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
            <h1 className="text-2xl text-white font-bold mb-4">¿Qué desea el cliente?</h1>            
            <div className="relative mt-4 w-64">
                <svg className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path 
                        fillRule="evenodd" 
                        clipRule="evenodd" 
                        d="M17.0392 15.6244C18.2714 14.084 19.0082 12.1301 19.0082 10.0041C19.0082 5.03127 14.9769 1 10.0041 1C5.03127 1 1 5.03127 1 10.0041C1 14.9769 5.03127 19.0082 10.0041 19.0082C12.1301 19.0082 14.084 18.2714 15.6244 17.0392L21.2921 22.707C21.6828 23.0977 22.3163 23.0977 22.707 22.707C23.0977 22.3163 23.0977 21.6828 22.707 21.2921L17.0392 15.6244ZM10.0041 17.0173C6.1308 17.0173 2.99087 13.8774 2.99087 10.0041C2.99087 6.1308 6.1308 2.99087 10.0041 2.99087C13.8774 2.99087 17.0173 6.1308 17.0173 10.0041C17.0173 13.8774 13.8774 17.0173 10.0041 17.0173Z" 
                        fill="currentColor"
                    />
                </svg>
                <input
                    type="text"
                    placeholder="Buscar producto..."
                    color="[#6b7280]"
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    className="w-full pl-11 pr-4 py-2 text-gray-700 rounded-md bg-gray-300 border border-gray-300 focus:outline-none focus:ring-2 focus:ring-red-500"
                />
            </div>
            <MenuCategoria />
            {loading && <p className="text-gray-600 mt-4">Cargando...</p>}
            {!loading && (
                <div className="grid grid-cols-4 gap-5 p-4 mt-5">
                    {filteredBebidas.map((producto) => (
                        <CardFood
                            key={`${uid}-${producto.id}`}
                            data={producto}
                            onAdd={(p) =>  addToCart(p)} // Aquí se añade al carrito
                        />
                    ))}
                </div>
            )}
            {!loading && filteredBebidas.length === 0 && (
                <p className="text-gray-500 mt-4">No hay productos disponibles</p>
            )}
            <SubNavegacion/>
        </div>
    );
}
