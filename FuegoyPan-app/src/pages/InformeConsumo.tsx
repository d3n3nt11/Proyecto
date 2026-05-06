import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import SubNavegacion from "../Components/SubNavegacion";
import { getConsumoIngredientes, descargarStockMovements } from "../data/api";
import logo from "../assets/logo.png";  

// Interfaz para los movimientos de ingredientes
interface MovimientoIngrediente {
    ingredientId: number;
    ingredientName?: string;
    quantity: number;
    unit?: string;  
    type: "SALE" | "RESTOCK" | "ADJUSTMENT";
    saleId?: number;
}

export default function InformeConsumo() {
    const navigate = useNavigate();
    
    // Filtros de fecha
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");
    
    // Datos y estado
    const [movimientos, setMovimientos] = useState<MovimientoIngrediente[]>([]);
    const [loading, setLoading] = useState(false);

    // Cargar datos cuando cambian las fechas (TU PATRÓN)
    useEffect(() => {
        if (!startDate || !endDate) return;

        const cargarDatos = async () => {
            setLoading(true);
            try {
                const data = await getConsumoIngredientes(startDate, endDate);
                setMovimientos(data);
            } catch (error) {
                console.error("Error cargando informe:", error);
                alert("No se pudieron cargar los datos");
            } finally {
                setLoading(false);
            }
        };

        cargarDatos();
    }, [startDate, endDate]);

    // Función para descargar CSV (usa el endpoint existente de stock-movements)
    const handleDescargar = async () => {
        if (!startDate || !endDate) {
            alert("Selecciona fechas primero");
            return;
        }
        try {
            const blob = await descargarStockMovements(startDate, endDate);
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement("a");
            a.href = url;
            a.download = `consumo_ingredientes_${startDate}_${endDate}.csv`;
            a.click();
            window.URL.revokeObjectURL(url);
        } catch (error) {
            console.error("Error descargando:", error);
            alert("Error al descargar el informe");
        }
    };

    // Helper para mostrar el tipo de movimiento con colores
    const getTipoBadge = (type: string) => {
        switch (type) {
            case "SALE": return "bg-red-100 text-red-800";
            case "RESTOCK": return "bg-green-100 text-green-800";
            case "ADJUSTMENT": return "bg-yellow-100 text-yellow-800";
            default: return "bg-gray-100 text-gray-800";
        }
    };

    // Helper para traducir el tipo
    const traducirTipo = (type: string) => {
        switch (type) {
            case "SALE": return "Venta";
            case "RESTOCK": return "Reposición";
            case "ADJUSTMENT": return "Ajuste";
            default: return type;
        }
    };

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src={logo} alt="logo" className="w-75 h-45 rounded-full mb-4"/>
            
            <h1 className="text-3xl text-white font-bold mb-6">
                Consumo de Ingredientes
            </h1>

            {/* Filtro de fechas */}
            <div className="bg-white rounded-2xl shadow-xl p-6 w-full max-w-2xl mb-6">
                <h2 className="text-xl font-bold mb-4 text-gray-800">
                    Filtrar por fechas
                </h2>
                
                <div className="grid grid-cols-2 gap-4 mb-4">
                    <div>
                        <label className="block text-sm font-semibold text-gray-700 mb-2">
                            Fecha inicio:
                        </label>
                        <input
                            type="date"
                            value={startDate}
                            onChange={(e) => setStartDate(e.target.value)}
                            className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-red-500"
                        />
                    </div>
                    
                    <div>
                        <label className="block text-sm font-semibold text-gray-700 mb-2">
                            Fecha fin:
                        </label>
                        <input
                            type="date"
                            value={endDate}
                            onChange={(e) => setEndDate(e.target.value)}
                            className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-red-500"
                        />
                    </div>
                </div>
            </div>

            {/* Botones de acción */}
            <div className="flex gap-4 mb-6">
                <button
                    onClick={handleDescargar}
                    disabled={!startDate || !endDate || loading}
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-xl transition-colors disabled:opacity-50"
                >
                    Descargar CSV
                </button>
                
                <button
                    onClick={() => navigate("/informes")}
                    className="bg-gray-600 hover:bg-gray-700 text-white font-bold py-3 px-6 rounded-xl"
                >
                    ← Volver
                </button>
            </div>

            {/* Tabla de resultados */}
            {loading && <p className="text-gray-600">Cargando datos...</p>}
            
            {!loading && movimientos.length > 0 && (
                <div className="bg-white rounded-2xl shadow-xl p-6 w-full max-w-4xl">
                    <h2 className="text-xl font-bold mb-4 text-gray-800">
                        Movimientos del período ({movimientos.length})
                    </h2>
                    
                    <div className="overflow-x-auto">
                        <table className="w-full">
                            <thead>
                                <tr className="border-b-2 border-gray-200">
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">Ingrediente ID</th>
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">Cantidad</th>
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">Tipo</th>
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">Venta ID</th>
                                </tr>
                            </thead>
                            <tbody>
                                {movimientos.map((mov, index) => (
                                    <tr key={index} className="border-b border-gray-100 hover:bg-gray-50">
                                        <td className="py-3 px-4">#{mov.ingredientId} {mov.ingredientName}</td>
                                        <td className={`py-3 px-4 font-bold ${
                                            mov.quantity < 0 ? 'text-red-600' : 'text-green-600'
                                        }`}>
                                            {mov.quantity > 0 ? '+' : ''}{mov.quantity} {mov.unit}
                                        </td>
                                        <td className="py-3 px-4">
                                            <span className={`px-3 py-1 rounded-full text-xs font-semibold ${getTipoBadge(mov.type)}`}>
                                                {traducirTipo(mov.type)}
                                            </span>
                                        </td>
                                        <td className="py-3 px-4 text-gray-500">
                                            {mov.saleId ? `#${mov.saleId}` : '-'}
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            )}

            {!loading && movimientos.length === 0 && (startDate || endDate) && (
                <p className="text-gray-500 mt-4">No hay movimientos en este período</p>
            )}

            <SubNavegacion />
        </div>
    );
}