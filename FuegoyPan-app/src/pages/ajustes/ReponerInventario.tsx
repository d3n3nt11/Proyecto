import { useEffect, useState } from "react";
import type { IIngredient } from "../../types/Interfaces";
import { getIngredientes, moverStock } from "../../data/api";
import SubNavegacion from "../../Components/SubNavegacion";

export default function ReponerInventario() {

    const [ingredients, setIngredients] = useState<IIngredient[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");

    const [filteredIngredients, setFilteredIngredients] = useState<IIngredient[]>([]);

    //  cambios de stock
    const [changes, setChanges] = useState<{ [key: number]: number }>({});

    // caducidad 
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