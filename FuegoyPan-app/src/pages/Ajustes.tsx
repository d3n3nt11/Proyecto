import React from 'react'
import SubNavegacion from '../Components/SubNavegacion'
import { useNavigate } from 'react-router-dom'

export default function Ajustes() {
    const navigate = useNavigate();
    return (
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
            <h1 className="text-2xl text-white font-bold mb-4">¿Qué ajustes deseas hacer?</h1>  
            <div className='flex flex-col items-center gap-4 w-full max-w-md px-4'>
                <button onClick={() => navigate('/ajustes/VerInventario')} type="button" className='bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full'>Consultar el Inventario</button>          
                <button onClick={() => navigate('/ajustes/ReponerInventario')} type="button" className='bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full'>Reponer el Inventario</button>
                <button onClick={() => navigate('/ajustes/ConfigurarPorcentaje')} type="button" className='bg-red-600 hover:bg-red-700 text-white font-bold py-3 px-6 rounded-full w-full'>Configurar el Porcentaje</button>
            </div>
            <SubNavegacion/>
        </div>
    )
}
