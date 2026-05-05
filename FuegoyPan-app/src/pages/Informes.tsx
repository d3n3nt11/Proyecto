import { useState } from 'react'
import SubNavegacion from '../Components/SubNavegacion'
import { descargarInformeCSV, descargarStockMovements } from '../data/api';

export default function Informes() {

    const [loading, setLoading] = useState(false);

    //  Calcula el mes actual automáticamente
    const getCurrentMonthRange = () => {
        const now = new Date();

        const start = new Date(now.getFullYear(), now.getMonth(), 1);
        const end = new Date(now.getFullYear(), now.getMonth() + 1, 0);

        const format = (date: Date) => date.toISOString().split("T")[0];

        return {
            start: format(start),
            end: format(end),
        };
    };

    const handleDownload = async () => {
        try {
            setLoading(true);

            const { start, end } = getCurrentMonthRange();

            const blob = await descargarInformeCSV(start, end);

            const url = window.URL.createObjectURL(blob);
            const a = document.createElement("a");

            a.href = url;
            a.download = "informe_ventas.csv";
            a.click();

            window.URL.revokeObjectURL(url);

        } catch (error) {
            console.error(error);
            alert("Error al generar el informe");
        } finally {
            setLoading(false);
        }
    };

    const handleStockDownload = async () => {
        try {
            const { start, end } = getCurrentMonthRange();

            const blob = await descargarStockMovements(start, end);

            const url = window.URL.createObjectURL(blob);
            const a = document.createElement("a");

            a.href = url;
            a.download = "stock_movements.csv";
            a.click();

            window.URL.revokeObjectURL(url);

        } catch (error) {
            console.error(error);
            alert("Error al generar el informe de stock");
        }
    };

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">

            <img
                src="src/assets/logo.png"
                alt="logo"
                className="w-75 h-45 rounded-full"
            />

            <h1 className="text-2xl text-white font-bold mb-4">
                Informes del sistema
            </h1>

            <div className="flex flex-col items-center gap-4 w-full max-w-md px-4">

                {/* 📊 Ventas */}
                <button
                    onClick={handleDownload}
                    disabled={loading}
                    type="button"
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                >
                    {loading ? "Generando informe..." : "Descargar informe de ventas"}
                </button>

                {/* 📦 Stock */}
                <button
                    onClick={handleStockDownload}
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                >
                    Descargar movimientos de stock
                </button>

                {/* 🍽️ Placeholder */}
                <button
                    type="button"
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                    onClick={() => alert("Próximamente: consumo de ingredientes")}
                >
                    Consumo de ingredientes
                </button>

            </div>

            <SubNavegacion />
        </div>
    )
}