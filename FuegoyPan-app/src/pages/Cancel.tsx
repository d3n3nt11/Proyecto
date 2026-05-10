// Cancel.tsx
import { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Cancel() {
  const navigate = useNavigate();

  // Verificar token al montar
  useEffect(() => {
    const token = localStorage.getItem("token");
    const saleId = localStorage.getItem("saleId");
    
    // Si no hay token, redirigir a login
    if (!token) {
      navigate("/inicio");
      return;
    }
    
    // Si hay token pero no hay venta, ir a comprar
    if (!saleId) {
      navigate("/comprar");
    }
    // Si hay token y venta, quedarse en /cancel para mostrar mensaje
  }, [navigate]);

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-50 px-4">
      <div className="bg-white shadow-lg rounded-2xl p-8 max-w-md w-full text-center">
        <h1 className="text-3xl font-bold text-red-600 mb-4">
          Pago cancelado
        </h1>
        <p className="text-gray-600 mb-6">
          No se ha realizado ningún cargo. Puedes volver a intentarlo cuando quieras.
        </p>
        <div className="flex flex-col gap-3">
          {/*Botón que verifica token antes de navegar */}
          <button
            onClick={() => {
              const token = localStorage.getItem("token");
              const saleId = localStorage.getItem("saleId");
              
              if (token && saleId) {
                navigate("/pago");  // Volver a elegir método de pago
              } else if (token) {
                navigate("/comprar");  // Ir a carrito
              } else {
                navigate("/inicio");  // Sin token, ir a login
              }
            }}
            className="bg-red-600 text-white px-6 py-2 rounded-xl hover:bg-red-700 transition"
          >
            Intentar de nuevo
          </button>
          
          <Link
            to="/burger"
            className="text-gray-600 hover:text-gray-900 transition"
          >
            Volver a la tienda
          </Link>
        </div>
      </div>
    </div>
  );
}