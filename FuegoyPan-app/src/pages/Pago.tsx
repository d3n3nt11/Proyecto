import { useState } from "react";
import { updateSaleStatus } from "../data/saleApi";
import { useNavigate } from "react-router-dom";

export default function Pago() {
  const navigate = useNavigate();
  const saleId = localStorage.getItem("saleId");

  const [loading, setLoading] = useState(false);

  const changeStatus = async (status: "PAID" | "CANCELLED") => {
  if (!saleId) {
    alert("No hay venta activa");
    return;
  }

  try {
    setLoading(true);

    await updateSaleStatus(Number(saleId), status);

    alert(`Venta ${status === "PAID" ? "pagada" : "cancelada"}`);

    localStorage.removeItem("saleId");

    navigate("/burger");

  } catch (err) {
    console.error(err);
    alert(err instanceof Error ? err.message : "Error");
  } finally {
    setLoading(false);
  }
};

  return (
    <div className="min-h-screen flex flex-col items-center justify-center bg-[#F2E9DB]">

      <h1 className="text-2xl font-bold mb-6">
        Finalizar pago
      </h1>

      <div className="bg-white p-6 rounded-2xl shadow-lg w-80 text-center">

        <p className="mb-4">Elige una opción:</p>

        <button
          onClick={() => changeStatus("PAID")}
          disabled={loading}
          className="w-full bg-green-600 text-white py-2 rounded-xl mb-3"
        >
          Pagar 💳
        </button>

        <button
          onClick={() => changeStatus("CANCELLED")}
          disabled={loading}
          className="w-full bg-red-600 text-white py-2 rounded-xl"
        >
          Cancelar ❌
        </button>

      </div>
    </div>
  );
}