// VerInventario.tsx

import { useEffect, useState } from "react";
import { getIngredientes } from "../../data/api";
import type { IIngredient } from "../../types/Interfaces";
import SubNavegacion from "../../Components/SubNavegacion";

export default function VerInventario() {
    const [ingredients, setIngredients] = useState<IIngredient[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");
    const [filteredIngredients, setFilteredIngredients] = useState<IIngredient[]>([]);

    useEffect(() => {
        const cargarIngredientes = async () => {
            try {
                const data = await getIngredientes();
                setIngredients(data);
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

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src="../src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full" />

            <h1 className="text-2xl text-white font-bold mb-4">
                Este es tu inventario actual
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
                <div className="grid grid-cols-3 p-4 gap-4">
                    {filteredIngredients.map((ingredient) => (
                        <div
                            key={ingredient.ingredientId}
                            className="bg-white rounded-2xl shadow-lg p-3 flex flex-row gap-3 justify-between items-center mb-4"
                        >
                            <img
                                src={ingredient.image}
                                alt={ingredient.ingredientName}
                                className="rounded-lg h-20 w-20"
                            />

                            <h3 className="font-semibold text-xl text-center mb-2 text-gray-800">
                                {ingredient.ingredientName}
                            </h3>

                            <div className="text-center mb-2">
                                <p className="text-lg font-semibold text-red-600">
                                    {ingredient.currentStock} {ingredient.unit}
                                </p>
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