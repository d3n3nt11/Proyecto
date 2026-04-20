import SubNavegacion from "../Components/SubNavegacion";
import { useCart } from "../context/cartContext";
import { createSale } from "../data/saleApi";

export default function Comprar() {
  const { cart, removeFromCart, clearCart } = useCart();

  const total = cart.reduce(
    (acc, item) => acc + item.price * item.quantity,
    0
  );

  const handleCheckout = async () => {
  const token = localStorage.getItem("token");
  console.log("TOKEN:", token);

  const sale = {
    status: "OPEN", 
    lines: cart.map(item => ({
      productId: item.id,
      quantity: item.quantity
    }))
  };

  try {
    await createSale(sale);
    alert("Compra realizada");
    clearCart();
  } catch (err) {
    console.error("ERROR CHECKOUT:", err);
    alert("Error al pagar");
  }
};

  return (
    <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
      <img src="src/assets/logo.png" className="w-75 h-45 rounded-full" />

      <h1 className="text-2xl text-white font-bold mb-4">
        ¿Listo para comprar?
      </h1>

      <div className="bg-white rounded-2xl shadow-lg p-5 w-100">

        {cart.length === 0 && (
          <p className="text-center text-gray-500">
            El carrito está vacío
          </p>
        )}

        {cart.map(item => (
          <div key={item.id} className="flex justify-between border-b py-2">
            <div>
              <p className="font-bold">{item.name}</p>
              <p className="text-sm">
                {item.quantity} x {item.price}€
              </p>
            </div>

            <button
              onClick={() => removeFromCart(item.id)}
              className="text-red-500"
            >
              ✕
            </button>
          </div>
        ))}

        {cart.length > 0 && (
          <>
            <p className="text-right font-bold mt-4">
              Total: {total.toFixed(2)}€
            </p>

            <button
              onClick={handleCheckout}
              className="w-full bg-red-600 text-white py-2 mt-4 rounded-xl"
            >
              Pagar
            </button>
          </>
        )}
      </div>

      <SubNavegacion />
    </div>
  );
}