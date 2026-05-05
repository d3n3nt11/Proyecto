import { Link } from "react-router-dom";

export default function Cancel() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-50 px-4">

      <div className="bg-white shadow-lg rounded-2xl p-8 max-w-md w-full text-center">

        <h1 className="text-3xl font-bold text-red-600 mb-4">
          ❌ Pago cancelado
        </h1>

        <p className="text-gray-600 mb-6">
          No se ha realizado ningún cargo. Puedes volver a intentarlo cuando quieras.
        </p>

        <div className="flex flex-col gap-3">

          <Link
            to="/cart"
            className="bg-red-600 text-white px-6 py-2 rounded-xl hover:bg-red-700 transition"
          >
            Intentar de nuevo
          </Link>

          <Link
            to="/inicio"
            className="text-gray-600 hover:text-gray-900 transition"
          >
            Volver a la tienda
          </Link>

        </div>

      </div>
    </div>
  );
}