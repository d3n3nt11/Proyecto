import { Link, useSearchParams } from "react-router-dom";

export default function Success() {
  const [params] = useSearchParams();
  const sessionId = params.get("session_id");

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-50 px-4">
      
      <div className="bg-white shadow-lg rounded-2xl p-8 max-w-md w-full text-center">
        
        <h1 className="text-3xl font-bold text-green-600 mb-4">
          ✅ Pago completado
        </h1>

        <p className="text-gray-600 mb-4">
          Tu pedido ha sido procesado correctamente.
        </p>

        {sessionId && (
          <p className="text-sm text-gray-400 mb-6">
            ID de sesión: {sessionId}
          </p>
        )}

        <Link
          to="/inicio"
          className="inline-block bg-green-600 text-white px-6 py-2 rounded-xl hover:bg-green-700 transition"
        >
          Volver al inicio
        </Link>

      </div>
    </div>
  );
}