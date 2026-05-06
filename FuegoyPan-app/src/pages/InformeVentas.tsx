import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import SubNavegacion from "../Components/SubNavegacion";
import { getVentasPorFechas, descargarInformeCSV } from "../data/api";
import logo from "../assets/logo.png";  

// Interfaz para los datos que vienen del backend
interface VentaResumen {
    id: number;
    date: string;
    total: number;
    status: string;
    userId?: number;
    userName?: string;  
}

export default function InformeVentas() {
    const navigate = useNavigate();
    
    // Filtros de fecha
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");
    
    // Datos y estado
    const [ventas, setVentas] = useState<VentaResumen[]>([]);
    const [loading, setLoading] = useState(false);

    // Cargar datos cuando cambian las fechas (TU PATRÓN)
    useEffect(() => {
        if (!startDate || !endDate) return;

        const cargarVentas = async () => {
            setLoading(true);
            try {
                const data = await getVentasPorFechas(startDate, endDate);
                setVentas(data);
            } catch (error) {
                console.error("Error cargando informe:", error);
                alert("No se pudieron cargar los datos");
            } finally {
                setLoading(false);
            }
        };

        cargarVentas();
    }, [startDate, endDate]);

    // Función para descargar CSV (la que ya tenías)
    const handleDescargar = async () => {
        if (!startDate || !endDate) {
            alert("Selecciona fechas primero");
            return;
        }
        try {
            const blob = await descargarInformeCSV(startDate, endDate);
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement("a");
            a.href = url;
            a.download = `ventas_${startDate}_${endDate}.csv`;
            a.click();
            window.URL.revokeObjectURL(url);
        } catch (error) {
            console.error("Error descargando:", error);
            alert("Error al descargar el informe");
        }
    };

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src={logo} alt="logo" className="w-75 h-45 rounded-full mb-4"/>
            
            <h1 className="text-3xl text-white font-bold mb-6">
                Informe de Ventas
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
            
            {!loading && ventas.length > 0 && (
                <div className="bg-white rounded-2xl shadow-xl p-6 w-full max-w-4xl">
                    <h2 className="text-xl font-bold mb-4 text-gray-800">
                        Ventas del período seleccionado ({ventas.length})
                    </h2>
                    
                    <div className="overflow-x-auto">
                        <table className="w-full">
                            <thead>
                                <tr className="border-b-2 border-gray-200">
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">ID</th>
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">Fecha</th>
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">Total</th>
                                    <th className="text-left py-3 px-4 font-semibold text-gray-700">Estado</th>
                                </tr>
                            </thead>
                            <tbody>
                                {ventas.map((venta) => (
                                    <tr key={venta.id} className="border-b border-gray-100 hover:bg-gray-50">
                                        <td className="py-3 px-4">{venta.id} {venta.userName && `- ${venta.userName}`}</td>
                                        <td className="py-3 px-4">
                                            {new Date(venta.date).toLocaleString('es-ES')}
                                        </td>
                                        <td className="py-3 px-4 font-bold text-red-600">
                                            {venta.total?.toFixed(2) ?? '0.00'}€
                                        </td>
                                        <td className="py-3 px-4">
                                            <span className={`px-3 py-1 rounded-full text-xs font-semibold ${
                                                venta.status === 'PAID' ? 'bg-green-100 text-green-800' :
                                                venta.status === 'CANCELLED' ? 'bg-red-100 text-red-800' :
                                                'bg-yellow-100 text-yellow-800'
                                            }`}>
                                                {venta.status}
                                            </span>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            )}

            {!loading && ventas.length === 0 && (startDate || endDate) && (
                <p className="text-gray-500 mt-4">No hay ventas en este período</p>
            )}

            <SubNavegacion />
        </div>
    );
}