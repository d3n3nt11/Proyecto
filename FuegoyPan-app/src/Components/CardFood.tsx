import React from 'react'
import type { IProducto } from '../types/Interfaces'

interface CardFoodProps {
    name: string;
    description: string;
    price: number;
    category: "comida" | "bebida" | "postre" | "salsa";
    imageUrl?: string;
}

export default function CardFood({ name, description, price, category, imageUrl }: CardFoodProps) {
    return (
        <div className='bg-white rounded-3xl shadow-2xl p-8 w-96 flex flex-col items-center justify-center  '>
            <img src={imageUrl} alt={name} />
            <h1>{name}</h1>
            <p>${price.toFixed(2)}</p>
        </div>
    )
}
