import React, { useEffect, useState } from "react";
import CardFood from "../Components/CardFood";
import { getSalsas } from "../data/api";  // ✅ Importamos la función para obtener salsas
import type { IProducto } from "../types/Interfaces";
import MenuCategoria from "../Components/MenuCategoria";

export default function Salsas() {
    // Generamos un ID único para las keys de React (evita warnings)
    const uid = React.useId();
    
    // Estado para almacenar la lista completa de salsas
    const [productos, setProductos] = useState<IProducto[]>([]);
    
    // Estado para controlar si está cargando los datos
    const [loading, setLoading] = useState(true);
    
    // Estado para el texto del buscador
    const [search, setSearch] = useState("");
    
    // Estado para las salsas filtradas según la búsqueda
    const [filteredSalsas, setFilteredSalsas] = useState<IProducto[]>([]);

    // ✅ useEffect #1: Cargar las salsas cuando el componente se monta
    useEffect(() => {
        const cargarSalsas = async () => {
            try {
                // Llamamos a la función que filtra por categoría "salsa"
                const data = await getSalsas();
                // Guardamos los datos en el estado
                setProductos(data);
            } catch (error) {
                // Si hay error, lo mostramos en consola
                console.error("Error cargando salsas:", error);
            } finally {
                // Terminamos el estado de carga (se ejecute o no con error)
                setLoading(false);
            }
        };
        // Ejecutamos la función asíncrona
        cargarSalsas();
    }, []); // El array vacío [] significa: "ejecutar solo al montar el componente"

    // ✅ useEffect #2: Filtrar las salsas cuando cambia el buscador o los productos
    useEffect(() => {
        if (search.trim() === "") {
            // Si el buscador está vacío, mostramos todas las salsas
            setFilteredSalsas(productos);
        } else {
            // Si hay texto, filtramos por nombre (ignorando mayúsculas/minúsculas)
            const findSalsas = productos.filter((p) =>
                p.name.toLowerCase().includes(search.toLowerCase())
            );
            setFilteredSalsas(findSalsas);
        }
    }, [search, productos]); // Se ejecuta cuando cambia 'search' o 'productos'

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            {/* Logo de la aplicación */}
            <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
            
            {/* Título principal */}
            <h1 className="text-2xl text-white font-bold mb-4">¿Qué desea el cliente?</h1>            
            
            {/* Barra de búsqueda con icono */}
            <div className="relative mt-4 w-64">
                {/* Icono de lupa (SVG) */}
                <svg className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-500" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path 
                        fillRule="evenodd" 
                        clipRule="evenodd" 
                        d="M17.0392 15.6244C18.2714 14.084 19.0082 12.1301 19.0082 10.0041C19.0082 5.03127 14.9769 1 10.0041 1C5.03127 1 1 5.03127 1 10.0041C1 14.9769 5.03127 19.0082 10.0041 19.0082C12.1301 19.0082 14.084 18.2714 15.6244 17.0392L21.2921 22.707C21.6828 23.0977 22.3163 23.0977 22.707 22.707C23.0977 22.3163 23.0977 21.6828 22.707 21.2921L17.0392 15.6244ZM10.0041 17.0173C6.1308 17.0173 2.99087 13.8774 2.99087 10.0041C2.99087 6.1308 6.1308 2.99087 10.0041 2.99087C13.8774 2.99087 17.0173 6.1308 17.0173 10.0041C17.0173 13.8774 13.8774 17.0173 10.0041 17.0173Z" 
                        fill="currentColor"
                    />
                </svg>
                
                {/* Input de búsqueda */}
                <input
                    type="text"
                    placeholder="Buscar producto..."
                    value={search}  // Valor controlado por el estado
                    onChange={(e) => setSearch(e.target.value)}  // Actualiza el estado al escribir
                    className="w-full pl-11 pr-4 py-2 text-gray-700 rounded-md bg-gray-300 border border-gray-300 focus:outline-none focus:ring-2 focus:ring-red-500"
                />
            </div>
            
            {/* Menú de categorías (para navegar entre secciones) */}
            <MenuCategoria />
            
            {/* Mensaje de carga mientras se obtienen los datos */}
            {loading && <p className="text-gray-600 mt-4">Cargando...</p>}
            
            {/* Grid de productos: solo se muestra cuando terminó de cargar */}
            {!loading && (
                <div className="grid grid-cols-4 gap-5 p-4 mt-5">
                    {filteredSalsas.map((producto) => (
                        <CardFood
                            key={`${uid}-${producto.id}`}  // Key única para React
                            data={producto}  // Pasamos los datos del producto
                            onAdd={(p) => console.log("Añadido:", p.name)}  // Callback al añadir
                        />
                    ))}
                </div>
            )}
            
            {/* Mensaje cuando no hay resultados (tras filtrar o si la lista está vacía) */}
            {!loading && filteredSalsas.length === 0 && (
                <p className="text-gray-500 mt-4">No hay productos disponibles</p>
            )}
        </div>
    );
}