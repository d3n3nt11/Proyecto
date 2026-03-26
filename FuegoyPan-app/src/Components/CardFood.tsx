import type { IProducto } from "../types/Interfaces";


interface CardFoodProps {
    data: IProducto;
    onAdd: (producto: IProducto) => void;
}

export default function CardFood({ data, onAdd }: CardFoodProps) {
    
    const handleAdd = () => {
        onAdd(data);
    };

    return (
        <div className='bg-white rounded-2xl shadow-lg p-2 flex flex-col items-center cursor-pointer hover:shadow-xl hover:scale-105 transition-all duration-200 border-2 border-transparent hover:border-red-300'>
            {/* Imagen del producto */}
            <div className="relative w-full">
                {data.imageUrl ? (
                    <img 
                        src={data.imageUrl} 
                        alt={data.name} 
                        className="w-full h-32 object-cover rounded-xl mb-2"
                    />
                ) : (
                    <div className="w-full h-32 bg-gray-200 rounded-xl mb-2 flex items-center justify-center">
                        <span className="text-gray-400 text-2xl">🍽️</span>
                    </div>
                )}
            </div>
            {/* Nombre del producto */}
            <h3 className="font-bold text-base text-center mb-1 text-gray-800 leading-tight">
                {data.name}
            </h3>
            {/* Descripción */}
            {data.description && (
                <p className="text-gray-500 text-xs text-center mb-2 line-clamp-2 px-1">
                    {data.description}
                </p>
            )}
            {/* Precio */}
            <p className="text-red-600 font-extrabold text-xl mb-3">
                ${data.price.toFixed(2)}
            </p>
            {/* Botón de añadir */}
            <button 
                onClick={handleAdd}
                className="w-full bg-red-600 hover:bg-red-700 active:bg-red-800 text-white font-bold py-2 px-4 rounded-xl transition-colors duration-150 text-sm flex items-center justify-center gap-1"
            >
                <span>+</span> Añadir
            </button>
        </div>
    )
}
