import { useEffect, useState } from 'react'
import type { IIngrediente } from '../../types/Interfaces';
import { getIngredientes, reponerInvenatario } from '../../data/api';
import SubNavegacion from '../../Components/SubNavegacion';

export default function ReponerInventario() {
    const [ingredientes, setIngredientes] = useState<IIngrediente[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");
    const [filteredIngredientes, setFilteredIngredientes] = useState<IIngrediente[]>([]);
    const [stockLocal, setStockLocal] = useState<{ [key: number]: number }>({}); // Estado local para el stock

    // UseEffect para cargar los ingredientes
    useEffect(() => {
        const cargarIngredientes = async () => {
            try {
                const data = await getIngredientes();
                setIngredientes(data);
                const stockInicial: { [key: number]: number } = {};
                data.forEach((ingrediente) => {
                    stockInicial[ingrediente.id] = ingrediente.cantidad; // Inicializa el stock local con los datos de la API
                });
                setStockLocal(stockInicial);
            } catch (error) {
                console.error("Error:", error);
            } finally {
                setLoading(false);
            }
        };
        cargarIngredientes();
    }, []);

    // UseEffect para el buscador
    useEffect(() => {
        if (search.trim() === "") {
            setFilteredIngredientes(ingredientes);
        } else {
            const findIngredientes = ingredientes.filter((i) =>
                i.nombre.toLowerCase().includes(search.toLowerCase())
            );
            setFilteredIngredientes(findIngredientes);
        }
    }, [search, ingredientes]);
    
    const aumentarStock = (id: number) => {
    // 1. Calculamos el nuevo valor
    const nuevoValor = (stockLocal[id] || 0) + 1;
    
    // 2. Actualizamos el estado local (la vista cambia al instante)
    setStockLocal(prev => ({
        ...prev,
        [id]: nuevoValor
    }));
    
    // 3. Enviamos el cambio al backend
    reponerInvenatario(id, nuevoValor);
    };

    const disminuirStock = (id: number) => {
    // 1. Calculamos el nuevo valor
    const nuevoValor = (stockLocal[id] || 0) - 1;
    
    // 2. Validación: no permitir stock negativo
    if (nuevoValor < 0) return;
    
    // 3. Actualizamos el estado local
    setStockLocal(prev => ({
        ...prev,
        [id]: nuevoValor
    }));
    
    // 4. Enviamos el cambio al backend
    reponerInvenatario(id, nuevoValor);
    };
    return (
    <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
        <img src="../src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
        <h1 className="text-2xl text-white font-bold mb-4">¿Qué ingredientes deseas reponer?</h1>            
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
            placeholder="Buscar ingrediente..."
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="w-full pl-11 pr-4 py-2 text-gray-700 rounded-md bg-gray-300 border border-gray-300"
            />
        </div>
        {loading && <p className="text-gray-600 mt-4">Cargando inventario...</p>}
        {!loading && (
            <div className="grid grid-cols-1 p-4 gap-4">
{filteredIngredientes.map((ingrediente) => (
    <div 
        key={ingrediente.id} 
        className="bg-white rounded-2xl shadow-lg p-3 flex flex-row items-center justify-between gap-3 mb-4"
    >
        {/* 1. IMAGEN (Izquierda) */}
        <img 
            src={ingrediente.imageUrl} 
            alt={ingrediente.nombre} 
            className="rounded-lg h-16 w-16 object-cover"
        />

        {/* 2. NOMBRE (Centro - ocupa el espacio disponible) */}
        <h3 className="font-semibold text-base text-gray-800 flex-1">
            {ingrediente.nombre}
        </h3>

        {/* 3. CONTROLES (Derecha: Botones y Cantidad) */}
        <div className="flex items-center gap-3">
            
            {/* Botón MENOS (-) */}
            <button 
                type="button" 
                onClick={() => disminuirStock(ingrediente.id)} // 👈 AQUÍ LLAMAMOS A LA FUNCIÓN
                className="bg-red-600 hover:bg-red-700 text-white font-bold w-8 h-8 rounded-full flex items-center justify-center shadow-md transition-all active:scale-90"
            >
                -
            </button>

            {/* Cantidad y Unidad */}
            <div className="text-center min-w-[50px]">
                {/* Gracias a React, este número cambia solo al pulsar los botones */}
                <p className="text-lg font-bold text-red-600">
                    {ingrediente.cantidad}
                </p>
                <p className="text-xs text-gray-500">
                    {ingrediente.unidad}
                </p>
            </div>

            {/* Botón MÁS (+) */}
            <button 
                type="button" 
                onClick={() => aumentarStock(ingrediente.id)} // 👈 AQUÍ LLAMAMOS A LA FUNCIÓN
                className="bg-red-600 hover:bg-red-700 text-white font-bold w-8 h-8 rounded-full flex items-center justify-center shadow-md transition-all active:scale-90"
            >
                +
            </button>

        </div>
    </div>
))}
            </div>
        )}
        {!loading && filteredIngredientes.length === 0 && (
            <p className="text-gray-500 mt-4">No se encontraron ingredientes</p>
        )}
        <SubNavegacion/>
    </div>
    )
}
