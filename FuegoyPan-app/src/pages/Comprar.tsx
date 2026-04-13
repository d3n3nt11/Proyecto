import React from 'react'
import SubNavegacion from '../Components/SubNavegacion'

export default function Comprar() {
    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
            <h1 className="text-2xl text-white font-bold mb-4">¿Listo para comprar?</h1>  
                <div className='bg-white rounded-2xl shadow-lg p-2 flex flex-col items-center cursor-pointer hover:shadow-xl hover:scale-105 transition-all duration-200 border-2 border-transparent'>
                    <p>Tu Pedido</p>
                </div>
            <SubNavegacion/>
        </div>
    )
}
