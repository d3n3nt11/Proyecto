import { createContext, useContext, useEffect, useState } from "react";
import type { IProducto } from "../types/Interfaces";

export interface CartItem extends IProducto {
  quantity: number;
}

interface CartContextType {
  cart: CartItem[];
  setCart: React.Dispatch<React.SetStateAction<CartItem[]>>;
  addToCart: (product: IProducto) => void;
  removeFromCart: (id: number) => void;
  clearCart: () => void;
}

const CartContext = createContext<CartContextType | null>(null);

export function CartProvider({ children }: { children: React.ReactNode }) {
  const [cart, setCart] = useState<CartItem[]>(() => {
    const stored = localStorage.getItem("cart");
    return stored ? JSON.parse(stored) : [];
  });

  //  persistencia automática
  useEffect(() => {
    localStorage.setItem("cart", JSON.stringify(cart));
  }, [cart]);

  // ➕ añadir producto
  const addToCart = (product: IProducto) => {
    setCart(prev => {
      const exists = prev.find(p => p.id === product.id);

      if (exists) {
        return prev.map(p =>
          p.id === product.id
            ? { ...p, quantity: p.quantity + 1 }
            : p
        );
      }

      return [...prev, { ...product, quantity: 1 }];
    });
  };

  //  eliminar producto
  const removeFromCart = (id: number) => {
    setCart(prev => prev.filter(p => p.id !== id));
  };

  //  vaciar carrito
  const clearCart = () => setCart([]);

  return (
    <CartContext.Provider value={{
      cart,
      setCart,
      addToCart,
      removeFromCart,
      clearCart
    }}>
      {children}
    </CartContext.Provider>
  );
}

export function useCart() {
  const context = useContext(CartContext);
  if (!context) throw new Error("useCart debe usarse dentro de CartProvider");
  return context;
}