import { useEffect, useState } from "react";
import type { IIngredient } from "../../types/Interfaces";
import { getIngredientes, moverStock } from "../../data/api";
import SubNavegacion from "../../Components/SubNavegacion";

export default function ReponerInventario() {

    const [ingredients, setIngredients] = useState<IIngredient[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");

    const [filteredIngredients, setFilteredIngredients] = useState<IIngredient[]>([]);

    // 🔥 cambios de stock
    const [changes, setChanges] = useState<{ [key: number]: number }>({});

    // 📅 caducidad (simple, opcional)
    const [expirations, setExpirations] = useState<{ [key: number]: string }>({});

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
            setFilteredIngredients(
                ingredients.filter((i) =>
                    i.ingredientName.toLowerCase().includes(search.toLowerCase())
                )
            );
        }
    }, [search, ingredients]);

    // ➕ aumentar stock
    const aumentarStock = (id: number) => {
        setChanges((prev) => ({
            ...prev,
            [id]: (prev[id] || 0) + 1
        }));
    };

    // ➖ disminuir stock
    const disminuirStock = (id: number) => {
        setChanges((prev) => {
            const actual = prev[id] || 0;
            if (actual <= 0) return prev;

            return {
                ...prev,
                [id]: actual - 1
            };
        });
    };

    // 📅 cambiar caducidad (simple)
    const cambiarCaducidad = (id: number, value: string) => {
        setExpirations((prev) => ({
            ...prev,
            [id]: value
        }));
    };

    // ❌ cancelar cambios
    const cancelarCambios = () => {
        setChanges({});
        setExpirations({});
    };

    // 💾 guardar cambios
    const guardarCambios = async () => {
        try {
            const requests = Object.entries(changes).map(([id, quantity]) => {
                if (quantity === 0) return null;

                return moverStock(
                    Number(id),
                    quantity,
                    "RESTOCK"
                );
            });

            await Promise.all(requests.filter(Boolean));

            setChanges({});
            setExpirations({});

            alert("Inventario actualizado correctamente");

        } catch (error) {
            console.error(error);
            alert("Error al actualizar inventario");
        }
    };

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">

            <img
                src="../src/assets/logo.png"
                alt="logo"
                className="w-75 h-45 rounded-full"
            />

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
                <p className="text-gray-600 mt-4">
                    Cargando inventario...
                </p>
            )}

            {/* LISTA */}
            {!loading && (
                <div className="grid grid-cols-1 p-4 gap-4 w-full">

                    {filteredIngredients.map((ingredient) => {

                        const pending = changes[ingredient.ingredientId] || 0;
                        const previewStock = ingredient.currentStock + pending;

                        return (
                            <div
                                key={ingredient.ingredientId}
                                className="bg-white rounded-2xl shadow-lg p-3 flex items-center justify-between gap-3"
                            >

                                {/* IMAGEN */}
                                <img
                                    src={ingredient.image}
                                    alt={ingredient.ingredientName}
                                    className="rounded-lg h-16 w-16 object-cover"
                                />

                                {/* INFO */}
                                <div className="flex flex-col flex-1">

                                    <h3 className="font-semibold text-base text-gray-800">
                                        {ingredient.ingredientName}
                                    </h3>

                                    <p className="text-lg font-bold text-red-600">
                                        {previewStock} {ingredient.unit}
                                    </p>

                                    {/* 📅 CADUCIDAD */}
                                    <input
                                        type="date"
                                        value={expirations[ingredient.ingredientId] || ingredient.expirationDate || ""}
                                        onChange={(e) =>
                                            cambiarCaducidad(ingredient.ingredientId, e.target.value)
                                        }
                                        className="mt-1 text-xs border rounded p-1"
                                    />
                                </div>

                                {/* CONTROLES */}
                                <div className="flex items-center gap-3">

                                    <button
                                        onClick={() => disminuirStock(ingredient.ingredientId)}
                                        className="bg-red-600 text-white w-8 h-8 rounded-full"
                                    >
                                        -
                                    </button>

                                    <button
                                        onClick={() => aumentarStock(ingredient.ingredientId)}
                                        className="bg-green-600 text-white w-8 h-8 rounded-full"
                                    >
                                        +
                                    </button>

                                </div>
                            </div>
                        );
                    })}
                </div>
            )}

            {/* BOTONES */}
            {!loading && (
                <div className="fixed bottom-20 flex gap-3">

                    {/* CANCELAR */}
                    {Object.keys(changes).length > 0 || Object.keys(expirations).length > 0 ? (
                        <button
                            onClick={cancelarCambios}
                            className="bg-gray-500 text-white px-6 py-3 rounded-xl"
                        >
                            Cancelar
                        </button>
                    ) : null}

                    {/* GUARDAR */}
                    {Object.keys(changes).length > 0 && (
                        <button
                            onClick={guardarCambios}
                            className="bg-black text-white px-6 py-3 rounded-xl shadow-lg"
                        >
                            Guardar cambios
                        </button>
                    )}

                </div>
            )}

            {!loading && filteredIngredients.length === 0 && (
                <p className="text-gray-500 mt-4">
                    No se encontraron ingredientes
                </p>
            )}

            <SubNavegacion />
        </div>
    );
}