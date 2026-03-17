import React from "react";
import { useState } from "react";
import { login } from "../data/api";
import { useNavigate } from "react-router-dom";

export default function Login() {

  const[nombre,setNombre] = useState("");
  const[contraseña,setContraseña] = useState("");
  const [error, setError] = React.useState('');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();


  const enviarFormulario = async(e:any)=>{
    e.preventDefault();
    setError(''); 
    if(nombre.trim() === '' || contraseña.trim() === ''){
      setError('Por favor, completa todos los campos');
      return;
    }
    try {
      setLoading(true);
      // Intentamos hacer el login
      const response = await login({ name: nombre,password: contraseña });

      // Si llegamos aquí, el login fue exitoso
      localStorage.setItem("token", response.token);
      navigate("/burger");  // Solo redirigimos si todo fue bien
      
    } catch (err: any) {
      console.error("Error en login:", err);
      
      // Mostrar el mensaje completo del error
      const mensajeError = err.message || "Credenciales incorrectas";
      setError(mensajeError);
    } finally {
      setLoading(false);
    }
  }

    return (
    <div className='min-h-screen flex flex-col items-center justify-center bg-[url(https://images.pexels.com/photos/2983101/pexels-photo-2983101.jpeg?cs=srgb&dl=pexels-jonathan-borba-2983101.jpg&fm=jpg)] bg-cover bg-center'>
      <div className='mb-8'>
        <img src='/src/assets/logo.png' alt='Logo' className='w-75 h-45 rounded-full' />
      </div>
      <div className='bg-white rounded-3xl shadow-2xl p-8 w-96'>
        <h2 className='font-bold text-2xl text-center mb-3'>
          BIENVENIDO A FUEGO Y PAN
        </h2>
        {error && (
          <div className='mb-4 p-3 bg-red-100 border border-red-400 text-red-700 rounded-lg text-sm'>
            {error}
          </div>
        )}
        <form onSubmit={enviarFormulario}>
          <div className="mb-3">
            <input type='text' value={nombre} onChange={(e) => setNombre(e.target.value)} placeholder='Nombre de usuario' className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-1"/>
          </div>
          <div className="mb-3">
            <input type='password' value={contraseña} onChange={(e) => setContraseña(e.target.value)} placeholder='Contraseña' className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-1"/>
          </div>
          <button type="submit" className="bg-red-600 w-full text-white py-1 px-4 rounded-2xl" disabled={loading}>
            {loading ? "Iniciando sesión..." : "Inicia Sesión"}
          </button>
        </form>
      </div>
    </div>
    )
}