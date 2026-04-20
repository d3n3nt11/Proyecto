import React, { useState } from 'react'
import SubNavegacion from '../Components/SubNavegacion'
import { descargarInformeCSV, descargarStockMovements } from '../data/api';


export default function Informes() {

    const [loading, setLoading] = useState(false);

    const handleDownload = async () => {
        try {
            setLoading(true);

            const start = "2026-04-01";
            const end = "2026-04-30";

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

                <button
                    onClick={handleDownload}
                    disabled={loading}
                    type="button"
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                >
                    {loading ? "Generando informe..." : "Descargar informe de ventas"}
                </button>

               <button
                onClick={async () => {
                    const blob = await descargarStockMovements("2026-04-01", "2026-04-30");

                    const url = window.URL.createObjectURL(blob);
                    const a = document.createElement("a");

                    a.href = url;
                    a.download = "stock_movements.csv";
                    a.click();

                    window.URL.revokeObjectURL(url);
                }}
                className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
            >
                Descargar movimientos de stock
            </button>

                <button
                    type="button"
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                    onClick={() => alert("Próximamente: consumo de ingredientes")}
                >
                    Consumo de ingredientes
                </button>

            </div>

            <SubNavegacion/>
        </div>
    )
}