// ReponerInventario.tsx

import { useEffect, useState } from "react";
import type { IIngredient } from "../../types/Interfaces";
import { getIngredientes, reponerInvenatario } from "../../data/api";
import SubNavegacion from "../../Components/SubNavegacion";

export default function ReponerInventario() {
    const [ingredients, setIngredients] = useState<IIngredient[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");
    const [filteredIngredients, setFilteredIngredients] = useState<IIngredient[]>([]);
    const [stockLocal, setStockLocal] = useState<{ [key: number]: number }>({});

    useEffect(() => {
        const cargarIngredientes = async () => {
            try {
                const data = await getIngredientes();
                setIngredients(data);

                const stockInicial: { [key: number]: number } = {};
                data.forEach((ingredient) => {
                    stockInicial[ingredient.ingredientId] = ingredient.currentStock;
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

    useEffect(() => {
        if (search.trim() === "") {
            setFilteredIngredients(ingredients);
        } else {
            const filtrados = ingredients.filter((i) =>
                i.ingredientName.toLowerCase().includes(search.toLowerCase())
            );

            setFilteredIngredients(filtrados);
        }
    }, [search, ingredients]);

    const aumentarStock = (id: number) => {
        const nuevoValor = (stockLocal[id] || 0) + 1;

        setStockLocal((prev) => ({
            ...prev,
            [id]: nuevoValor,
        }));

        reponerInvenatario(id, nuevoValor);
    };

    const disminuirStock = (id: number) => {
        const nuevoValor = (stockLocal[id] || 0) - 1;

        if (nuevoValor < 0) return;

        setStockLocal((prev) => ({
            ...prev,
            [id]: nuevoValor,
        }));

        reponerInvenatario(id, nuevoValor);
    };

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src="../src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full" />

            <h1 className="text-2xl text-white font-bold mb-4">
                ¿Qué ingredientes deseas reponer?
            </h1>

            <div className="relative mt-4 w-64">
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
                    {filteredIngredients.map((ingredient) => (
                        <div
                            key={ingredient.ingredientId}
                            className="bg-white rounded-2xl shadow-lg p-3 flex flex-row items-center justify-between gap-3 mb-4"
                        >
                            <img
                                src={ingredient.imageUrl}
                                alt={ingredient.ingredientName}
                                className="rounded-lg h-16 w-16 object-cover"
                            />

                            <h3 className="font-semibold text-base text-gray-800 flex-1">
                                {ingredient.ingredientName}
                            </h3>

                            <div className="flex items-center gap-3">
                                <button
                                    type="button"
                                    onClick={() => disminuirStock(ingredient.ingredientId)}
                                    className="bg-red-600 hover:bg-red-700 text-white font-bold w-8 h-8 rounded-full flex items-center justify-center shadow-md transition-all active:scale-90"
                                >
                                    -
                                </button>

                                <div className="text-center min-w-[50px]">
                                    <p className="text-lg font-bold text-red-600">
                                        {stockLocal[ingredient.ingredientId] ?? 0}
                                    </p>

                                    <p className="text-xs text-gray-500">
                                        {ingredient.unit}
                                    </p>
                                </div>

                                <button
                                    type="button"
                                    onClick={() => aumentarStock(ingredient.ingredientId)}
                                    className="bg-red-600 hover:bg-red-700 text-white font-bold w-8 h-8 rounded-full flex items-center justify-center shadow-md transition-all active:scale-90"
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