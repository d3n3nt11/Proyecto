import { useEffect, useState } from "react";
import type { IIngredient } from "../../types/Interfaces";
import { getIngredientes, moverStock } from "../../data/api";
import SubNavegacion from "../../Components/SubNavegacion";

export default function ReponerInventario() {

    const [ingredients, setIngredients] = useState<IIngredient[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");
    const [filteredIngredients, setFilteredIngredients] = useState<IIngredient[]>([]);
    const [stockValues, setStockValues] = useState<{ [key: number]: number }>({});
    // Caducidad 
    const [expirations, setExpirations] = useState<{ [key: number]: string }>({});

    useEffect(() => {
        const cargarIngredientes = async () => {
            try {
                const data = await getIngredientes();
                setIngredients(data);
                const stockInicial: { [key: number]: number } = {};
                data.forEach((ingredient) => {
                    stockInicial[ingredient.ingredientId] = ingredient.currentStock;
                });
                setStockValues(stockInicial);

            } catch (error) {
                console.error("Error:", error);
            } finally {
                setLoading(false);
            }
        };
        cargarIngredientes();
    }, []);

    useEffect(() => {
        if (search.trim() === "") {
            setFilteredIngredients(ingredients);
        } else {
            setFilteredIngredients(
                ingredients.filter((i) =>
                    i.ingredientName.toLowerCase().includes(search.toLowerCase())
                )
            );
        }
    }, [search, ingredients]);

    //aumentar stock
    const aumentarStock = (id: number) => {
        const nuevoValor = (stockValues[id] || 0) + 1;
        setStockValues((prev) => ({
            ...prev,
            [id]: nuevoValor,
        }));
        moverStock(id, 1, "RESTOCK"); 
    };

    //disminuir stock
    const disminuirStock = (id: number) => {
        const nuevoValor = (stockValues[id] || 0) - 1;
        if (nuevoValor < 0) return;  // No permitir stock negativo
        setStockValues((prev) => ({
            ...prev,
            [id]: nuevoValor,
        }));
        moverStock(id, -1, "RESTOCK"); 
    };

    // Cambiar caducidad (solo visual por ahora)
    const cambiarCaducidad = (id: number, value: string) => {
        setExpirations((prev) => ({
            ...prev,
            [id]: value
        }));
        // ⚠️ Aquí iría la llamada a la API si tuvieras endpoint para caducidad
    };

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">

            <img src="../src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>

            <h1 className="text-2xl text-white font-bold mb-4">
                Reponer inventario
            </h1>

            {/* SEARCH */}
            <div className="relative mt-4 w-64">
                <input
                    type="text"
                    placeholder="Buscar ingrediente..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    className="w-full pl-4 pr-4 py-2 text-gray-700 rounded-md bg-gray-300 border border-gray-300"
                />
            </div>

            {/* LOADING */}
            {loading && (
                <p className="text-gray-600 mt-4">Cargando inventario...</p>
            )}

            {/* LISTA DE INGREDIENTES */}
            {!loading && (
                <div className="grid grid-cols-1 p-4 gap-4 w-full max-w-5xl">
                    {filteredIngredients.map((ingredient) => (
                        <div 
                            key={ingredient.ingredientId} 
                            className="bg-white rounded-2xl shadow-lg p-4 grid grid-cols-6 gap-4 items-center"
                        >
                            {/* IMAGEN */}
                            <div className="col-span-1">
                                <img
                                    src={ingredient.image}
                                    alt={ingredient.ingredientName}
                                    className="rounded-lg h-16 w-16 object-cover"
                                />
                            </div>
                            
                            {/* NOMBRE */}
                            <div className="col-span-1">
                                <h3 className="font-semibold text-base text-gray-800">
                                    {ingredient.ingredientName}
                                </h3>
                            </div>
                            
                            {/* STOCK - Muestra stockValues[id] (igual que ConfigurarInventario) */}
                            <div className="col-span-1">
                                <p className="text-lg font-bold text-red-600">
                                    {stockValues[ingredient.ingredientId] ?? 0} {ingredient.unit}
                                </p>
                            </div>
                            
                            {/* CADUCIDAD */}
                            <div className="col-span-1">
                                <input
                                    type="date"
                                    value={expirations[ingredient.ingredientId] || ingredient.expirationDate || ""}
                                    onChange={(e) =>
                                        cambiarCaducidad(ingredient.ingredientId, e.target.value)
                                    }
                                    className="text-sm border rounded-lg p-2 w-full"
                                />
                            </div>
                            
                            {/* BOTONES +/- (mismo patrón que ConfigurarInventario) */}
                            <div className="col-span-2 flex items-center justify-end gap-3">
                                <button
                                    onClick={() => disminuirStock(ingredient.ingredientId)}
                                    className="bg-red-600 hover:bg-red-700 text-white w-10 h-10 rounded-full font-bold text-lg transition-colors"
                                >
                                    -
                                </button>
                                <button
                                    onClick={() => aumentarStock(ingredient.ingredientId)}
                                    className="bg-green-600 hover:bg-green-700 text-white w-10 h-10 rounded-full font-bold text-lg transition-colors"
                                >
                                    +
                                </button>
                            </div>
                        </div>
                    ))}
                </div>
            )}

            {!loading && filteredIngredients.length === 0 && (
                <p className="text-gray-500 mt-4">No se encontraron ingredientes</p>
            )}

            <SubNavegacion />
        </div>
    );
}