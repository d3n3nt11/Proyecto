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
        // 👇 Aumentamos la altura a 340px
        <div className='bg-white rounded-2xl shadow-lg p-3 flex flex-col h-[340px] w-full cursor-pointer hover:shadow-xl hover:scale-105 transition-all duration-200 border-2 border-transparent hover:border-red-300 overflow-hidden'>
            
            {/* Imagen - Altura fija */}
            <div className="w-full mb-3 flex-shrink-0">
                <img 
                    src={data.imageUrl} 
                    alt={data.name} 
                    className="w-full h-36 object-cover rounded-xl"
                    onError={(e) => {
                        (e.target as HTMLImageElement).style.display = 'none';
                    }}
                />
            </div>

            {/* Nombre - Altura fija */}
            <h3 className="font-bold text-base text-center mb-2 text-gray-800 leading-tight h-12 flex items-center justify-center px-1">
                {data.name}
            </h3>

            {/* Descripción - Altura fija */}
            {data.description && (
                <p className="text-gray-500 text-xs text-center mb-3 line-clamp-2 px-1 h-8 flex-shrink-0">
                    {data.description}
                </p>
            )}

            {/* Espacio flexible */}
            <div className="flex-1"></div>

            {/* Precio */}
            <p className="text-red-600 font-extrabold text-xl mb-3 flex-shrink-0">
                {data.price.toFixed(2)}€
            </p>

            {/* Botón - Siempre visible al final */}
            <button 
                onClick={handleAdd}
                className="w-full bg-red-600 hover:bg-red-700 active:bg-red-800 text-white font-bold py-2 px-4 rounded-xl transition-colors duration-150 text-sm flex items-center justify-center gap-1 flex-shrink-0"
            >
                <span>+</span> Añadir
            </button>
        </div>
    )
}