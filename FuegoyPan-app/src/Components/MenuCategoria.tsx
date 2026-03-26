import { NavLink } from "react-router-dom";

export default function NavMenu() {
    
    const categorias = [
        { path: "/burger", nombre: "Comida"},
        { path: "/bebidas", nombre: "Bebidas"},
        { path: "/salsas", nombre: "Salsas"},
        { path: "/postre", nombre: "Postre"},
    ];

    return (
        <div className="flex justify-center gap-10">
            {categorias.map((cat) => (
                <NavLink
                    key={cat.path}
                    to={cat.path}
                    className={({ isActive }) =>
                        `mt-7 px-10 py-2 rounded-xl font-bold text-sm  ${
                            isActive
                                ? "bg-red-600 text-white shadow-lg scale-105"
                                : "bg-white text-gray-700 hover:bg-gray-100"
                        }`
                    }
                >
                    {cat.nombre}
                </NavLink>
            ))}
        </div>
    );
}