import { useEffect, useState } from 'react'
import SubNavegacion from '../Components/SubNavegacion'
import { getMe } from '../data/api';
import type { IUser } from '../types/Interfaces';
import { useNavigate } from 'react-router-dom';

export default function Perfil() {

    const navegacion = useNavigate();
    const [usuario, setUsuario] = useState<IUser | null>(null);
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState<string>("");

    useEffect(() => {
        const cargarPerfil = async () => {
        try {
                // Intentamos obtener los datos del usuario logueado
                const datos = await getMe();
                
                // Si todo va bien, guardamos los datos en el estado "usuario"
                setUsuario(datos);
                
                // Limpiamos cualquier error previo por seguridad
                setError("");
                
            } catch (err: any) {
                // Si hay error lo guardamos para mostrarlo
                console.error("Error cargando perfil:", err);
                setError("No se pudo cargar la información del usuario");
                
            } finally {
                // Terminamos el estado de carga (se ejecute con éxito o error)
                setCargando(false);
            }
        };
        cargarPerfil();
    }, []);

    const cerrarSesion = () => {
        // Eliminamos el token del localStorage
        localStorage.removeItem("token");
        // Redirigimos al login o home
        navegacion("/inicio");
    };

    return (
        
        <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center py-10">
            {cargando && (
                <p className="text-gray-600 mt-4">Cargando perfil...</p>
            )}
            {error && !cargando && (
                <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded-lg mt-4">
                    {error}
                </div>
            )}
            <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
            { usuario && !cargando && !error && (
                <div className=' flex flex-row gap-6 items-center bg-white rounded-2xl shadow-lg p-6 w-80 text-center'>
                    <div className='mb-4'>
                        <img src={usuario.profilePhoto} alt="Foto de perfil" className="w-24 h-24 rounded-full border-2 border-red-600 mx-auto"/>
                    </div>
                    <div>
                        <h2 className='text-xl font-bold'>{usuario.role}</h2>
                        <p className='text-gray-600'>{usuario.name}</p>
                    </div>
                </div>
            )}
            {/* Botón de cerrar sesión*/}
            <button onClick={cerrarSesion}  className="mt-6 bg-red-600 hover:bg-red-700 text-white font-bold py-2 px-4 rounded-xl transition-colors">
                Cerrar Sesión
            </button>
            <SubNavegacion/>
        </div>
    )
}
