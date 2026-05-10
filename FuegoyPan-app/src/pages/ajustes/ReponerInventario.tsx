import { useEffect, useState } from "react";
import type { IIngredient } from "../../types/Interfaces";

import { getIngredientes, reponerInventarioBatch } from "../../data/api";

import SubNavegacion from "../../Components/SubNavegacion";

export default function ReponerInventario() {

    const [ingredients, setIngredients] = useState<IIngredient[]>([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");
    const [filteredIngredients, setFilteredIngredients] = useState<IIngredient[]>([]);
    
   
    const [stockLocal, setStockLocal] = useState<{ [key: number]: number }>({});
    
    const [expirationDates, setExpirationDates] = useState<{ [key: number]: string }>({});
    
    const [expandedIngredient, setExpandedIngredient] = useState<number | null>(null);

    useEffect(() => {
        const cargarIngredientes = async () => {
            try {
                const data = await getIngredientes();
                setIngredients(data);
                const stockInicial: { [key: number]: number } = {};
                const expirationInicial: { [key: number]: string } = {};
                
                data.forEach((ingredient) => {
                    stockInicial[ingredient.ingredientId] = ingredient.currentStock || 0;
                    if (ingredient.expirationDate) {
                        expirationInicial[ingredient.ingredientId] = ingredient.expirationDate;
                    }
                });
                
                setStockLocal(stockInicial);
                setExpirationDates(expirationInicial);
            } catch (error) {
                console.error("Error cargando ingredientes:", error);
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

  
    const handleStockChange = (id: number, value: number) => {
        if (value < 0) return;
        setStockLocal((prev) => ({
            ...prev,
            [id]: value,
        }));
    };

  
    const handleExpirationChange = (id: number, date: string) => {
        setExpirationDates((prev) => ({
            ...prev,
            [id]: date,
        }));
    };

    const generateBatchNumber = (): string => {
        const now = new Date();
        const datePart = now.toISOString().split("T")[0].replace(/-/g, ""); // YYYYMMDD
        const randomPart = Math.floor(1000 + Math.random() * 9000); // 4 dígitos aleatorios
        return `LOTE-${datePart}-${randomPart}`;
    };

   
    const reponerConLote = async (ingredientId: number) => {
        const quantity = stockLocal[ingredientId] || 0;
        const expirationDate = expirationDates[ingredientId];

        // Validaciones
        if (quantity <= 0) {
            alert(" La cantidad a reponer debe ser mayor a 0");
            return;
        }

        if (!expirationDate) {
            alert(" Debes seleccionar una fecha de caducidad para el lote");
            return;
        }

        // Validar que la fecha no sea pasada
        const today = new Date();
        const selectedDate = new Date(expirationDate);
        if (selectedDate < today) {
            alert("La fecha de caducidad no puede ser anterior a hoy");
            return;
        }

        try {
            setLoading(true);
            
          
            const batchNumber = generateBatchNumber();
            
           
            await reponerInventarioBatch({
                ingredientId,
                quantity,
                expirationDate,
                batchNumber,  // ← Número generado automáticamente
            });

            // Feedback visual
            alert(`✅ Lote creado: ${batchNumber}\n📦 ${quantity} ${getUnit(ingredientId)} caduca el ${formatDate(expirationDate)}`);
            
            // Resetear formulario de este ingrediente
            setExpandedIngredient(null);
            
            // Recargar datos para reflejar cambios
            const data = await getIngredientes();
            setIngredients(data);
            
            const stockActualizado: { [key: number]: number } = {};
            data.forEach((ing) => {
                stockActualizado[ing.ingredientId] = ing.currentStock || 0;
            });
            setStockLocal(stockActualizado);
            
        } catch (error) {
            console.error("Error al crear lote:", error);
            alert(" Error al reponer inventario. Intenta de nuevo.");
        } finally {
            setLoading(false);
        }
    };


    const getUnit = (id: number): string => {
        const ing = ingredients.find(i => i.ingredientId === id);
        return ing?.unit || "und";
    };

    
    const formatDate = (dateString: string): string => {
        if (!dateString) return "-";
        const date = new Date(dateString);
        return date.toLocaleDateString("es-ES", { 
            day: "2-digit", 
            month: "2-digit", 
            year: "numeric" 
        });
    };

    const getDaysUntilExpiration = (dateString: string): number | null => {
        if (!dateString) return null;
        const today = new Date();
        today.setHours(0, 0, 0, 0);
        const expDate = new Date(dateString);
        expDate.setHours(0, 0, 0, 0);
        const diffTime = expDate.getTime() - today.getTime();
        const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        return diffDays;
    };

    const getExpirationBadgeColor = (dateString: string): string => {
        const days = getDaysUntilExpiration(dateString);
        if (days === null) return "bg-gray-100 text-gray-600";
        if (days < 0) return "bg-red-100 text-red-700 border-red-300";
        if (days <= 3) return "bg-orange-100 text-orange-700 border-orange-300";
        if (days <= 7) return "bg-yellow-100 text-yellow-700 border-yellow-300";
        return "bg-green-100 text-green-700 border-green-300";
    };

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10 px-4">
            <img src="../src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full mb-6" />

            <h1 className="text-2xl text-white font-bold mb-2">
                📦 Repón tu inventario
            </h1>
            <p className="text-gray-600 text-sm mb-6">
                Cada reposición crea un nuevo lote con fecha de caducidad (sistema FIFO)
            </p>

            <div className="relative mt-2 w-full max-w-md">
                <input
                    type="text"
                    placeholder="🔍 Buscar ingrediente..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    className="w-full pl-11 pr-4 py-3 text-gray-700 rounded-xl bg-white border border-gray-300 shadow-sm focus:outline-none focus:ring-2 focus:ring-red-500"
                />
                <svg className="absolute left-3 top-3.5 w-5 h-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
                </svg>
            </div>

            {loading && <p className="text-gray-600 mt-6">⏳ Cargando inventario...</p>}

            {/* LISTA DE INGREDIENTES */}
            {!loading && (
                <div className="w-full max-w-2xl space-y-4 mt-4">
                    {filteredIngredients.map((ingredient) => {
                        const isExpanded = expandedIngredient === ingredient.ingredientId;
                        const currentStock = stockLocal[ingredient.ingredientId] || 0;
                        const expDate = expirationDates[ingredient.ingredientId];
                        const daysLeft = getDaysUntilExpiration(expDate);
                        
                        return (
                            <div
                                key={ingredient.ingredientId}
                                className="bg-white rounded-2xl shadow-lg p-4 flex flex-col gap-3 border border-gray-100"
                            >
                                {/* Header del ingrediente */}
                                <div className="flex items-center gap-4">
                                    <img
                                        src={ingredient.image || "/placeholder-ingredient.png"}
                                        alt={ingredient.ingredientName}
                                        className="rounded-xl h-16 w-16 object-cover border border-gray-200"
                                    />

                                    <div className="flex-1 min-w-0">
                                        <h3 className="font-semibold text-gray-800 truncate">
                                            {ingredient.ingredientName}
                                        </h3>
                                        
                                        {/* Badge de caducidad si existe */}
                                        {expDate && (
                                            <span className={`inline-flex items-center px-2 py-0.5 rounded-full text-xs font-medium border ${getExpirationBadgeColor(expDate)}`}>
                                                {daysLeft !== null && daysLeft < 0 
                                                    ? `Caducado` 
                                                    : daysLeft !== null && daysLeft <= 3 
                                                        ? ` ${daysLeft} días` 
                                                        : `${formatDate(expDate)}`
                                                }
                                            </span>
                                        )}
                                    </div>

                                    {/* Stock actual */}
                                    <div className="text-right min-w-[70px]">
                                        <p className="text-lg font-bold text-gray-800">
                                            {currentStock}
                                        </p>
                                        <p className="text-xs text-gray-500">
                                            {ingredient.unit} actuales
                                        </p>
                                    </div>
                                </div>

                                {/* Botón para expandir formulario de reposición */}
                                <button
                                    type="button"
                                    onClick={() => setExpandedIngredient(isExpanded ? null : ingredient.ingredientId)}
                                    className={`w-full py-2 px-4 rounded-xl font-medium transition-all ${
                                        isExpanded 
                                            ? "bg-gray-100 text-gray-700" 
                                            : "bg-red-50 text-red-600 hover:bg-red-100"
                                    }`}
                                >
                                    {isExpanded ? "✕ Cancelar reposición" : "Repón este ingrediente"}
                                </button>

                                {/* Formulario de lote (colapsable) */}
                                {isExpanded && (
                                    <div className="bg-gray-50 rounded-xl p-4 space-y-4 animate-fadeIn">
                                        {/* Cantidad a reponer */}
                                        <div>
                                            <label className="block text-sm font-medium text-gray-700 mb-2">
                                                Cantidad a añadir
                                            </label>
                                            <div className="flex items-center gap-3">
                                                <button
                                                    type="button"
                                                    onClick={() => handleStockChange(ingredient.ingredientId, Math.max(0, currentStock - 1))}
                                                    className="bg-gray-200 hover:bg-gray-300 text-gray-700 font-bold w-10 h-10 rounded-full flex items-center justify-center transition-all"
                                                >
                                                    −
                                                </button>

                                                <input
                                                    type="number"
                                                    min="0"
                                                    value={stockLocal[ingredient.ingredientId] || 0}
                                                    onChange={(e) => handleStockChange(ingredient.ingredientId, parseInt(e.target.value) || 0)}
                                                    className="w-20 text-center py-2 px-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-red-500 focus:border-red-500"
                                                />

                                                <button
                                                    type="button"
                                                    onClick={() => handleStockChange(ingredient.ingredientId, currentStock + 1)}
                                                    className="bg-red-600 hover:bg-red-700 text-white font-bold w-10 h-10 rounded-full flex items-center justify-center transition-all"
                                                >
                                                    +
                                                </button>

                                                <span className="text-sm text-gray-500 ml-2">
                                                    {ingredient.unit}
                                                </span>
                                            </div>
                                        </div>

                                        {/* Fecha de caducidad (OBLIGATORIA) */}
                                        <div>
                                            <label className="block text-sm font-medium text-gray-700 mb-2">
                                                Fecha de caducidad <span className="text-red-500">*</span>
                                            </label>
                                            <input
                                                type="date"
                                                value={expirationDates[ingredient.ingredientId] || ""}
                                                onChange={(e) => handleExpirationChange(ingredient.ingredientId, e.target.value)}
                                                min={new Date().toISOString().split("T")[0]}
                                                className="w-full py-2 px-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-red-500 focus:border-red-500"
                                                required
                                            />
                                            <p className="text-xs text-gray-500 mt-1">
                                                Los lotes se consumen por orden de caducidad (FIFO)
                                            </p>
                                        </div>


                                        {/* Botón confirmar */}
                                        <button
                                            type="button"
                                            onClick={() => reponerConLote(ingredient.ingredientId)}
                                            disabled={loading}
                                            className="w-full bg-red-600 hover:bg-red-700 disabled:bg-red-300 text-white font-bold py-3 px-4 rounded-xl shadow-md transition-all active:scale-95 flex items-center justify-center gap-2"
                                        >
                                            {loading ? (
                                                <>
                                                    <svg className="animate-spin h-5 w-5" viewBox="0 0 24 24">
                                                        <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" fill="none" />
                                                        <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
                                                    </svg>
                                                    Procesando...
                                                </>
                                            ) : (
                                                <>
                                                    Crear lote y reponer
                                                </>
                                            )}
                                        </button>
                                    </div>
                                )}
                            </div>
                        );
                    })}
                </div>
            )}

            {!loading && filteredIngredients.length === 0 && (
                <div className="text-center py-10">
                    <p className="text-gray-500 text-lg">🔍 No se encontraron ingredientes</p>
                    <button 
                        onClick={() => setSearch("")}
                        className="mt-3 text-red-600 hover:text-red-700 font-medium"
                    >
                        Limpiar búsqueda
                    </button>
                </div>
            )}

            <SubNavegacion />
        </div>
    );
}