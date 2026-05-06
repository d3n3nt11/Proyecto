import { useNavigate } from "react-router-dom";
import SubNavegacion from "../Components/SubNavegacion";

export default function Informes() {
    const navigate = useNavigate();

    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full mb-4"/>
            
            <h1 className="text-2xl text-white font-bold mb-6">
                Informes del sistema
            </h1>

            <div className="flex flex-col items-center gap-4 w-full max-w-md px-4">
                <button
                    onClick={() => navigate("/informes/ventas")}
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                >
                    Informe de Ventas
                </button>

                <button
                    onClick={() => navigate("/informes/stock")}
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                >
                    Movimientos de Stock
                </button>
                {/* En el div de botones, añade este tercer button: */}
                <button
                    onClick={() => navigate("/informes/consumo")}
                    className="bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full"
                >
                    Consumo de Ingredientes
                </button>
            </div>
            <SubNavegacion/>
        </div>
    );
}