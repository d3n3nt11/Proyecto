// src/pages/Login.tsx
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { login } from '../data/api'

export default function Login() {
  // Estados para el formulario
  const [nombre, setNombre] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)

  const navigate = useNavigate()

  // Función que se ejecuta al enviar el formulario
  const handleSubmit = async (e: any) => {
    e.preventDefault()  // Evita que la página se recargue
    setError('')        // Limpiamos errores previos

    // Validación: campos no vacíos
    if (!nombre.trim() || !password.trim()) {
      setError('Por favor, completa todos los campos')
      return
    }

    try {
      setLoading(true)

      // Llamamos a la API
      const response = await login({ 
        name: nombre,
        password: password 
      })

      // Guardamos el token
      localStorage.setItem('token', response.token)

      // Redirigimos a la página de burger
      navigate('/burger')

    } catch (err: any) {
      // Mostramos el error
      setError(err.message || 'Credenciales incorrectas')
    } finally {
      // 👇 Desactivamos loading
      setLoading(false)
    }
  }

    return (
    <div className='min-h-screen flex flex-col items-center justify-center bg-[url(https://images.pexels.com/photos/2983101/pexels-photo-2983101.jpeg?cs=srgb&dl=pexels-jonathan-borba-2983101.jpg&fm=jpg)] bg-cover bg-center'>
      <div className='mb-8'>
        <img src='/src/assets/logo.png' alt='Logo' className='w-75 h-45 rounded-full' />
      </div>
        <div className='bg-white rounded-3xl shadow-2xl p-8 w-96'>
            <h2 className='text-2xl font-bold text-center text-gray-800 mb-8'>
              Bienvenido a Fuego y Pan
            </h2>
            {error && (
            <div className='mb-4 p-3 bg-red-100 border border-red-400 text-red-700 rounded-lg text-sm'>
              {error}
            </div>
            )}
            <form onSubmit={handleSubmit} className='space-y-6'>
              <div>
                <input type='text' placeholder='Nombre de usuario' className='w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-red-500' value={nombre} onChange={(e) => setNombre(e.target.value)} disabled={loading}/>
              </div>
              <div>
                  <input 
                  type='password'
                  placeholder='Contraseña'
                  className='w-full px-4 py-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-red-500'
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  disabled={loading}
                  />
              </div>
              <button type='submit' disabled={loading} className='w-full bg-red-600 text-white font-bold py-4 rounded-full hover:bg-red-700 transition duration-300 shadow-lg disabled:opacity-50 disabled:cursor-not-allowed'>
                {loading ? 'Iniciando sesión...' : 'Inicia Sesión'}
              </button>
            </form>
        </div>
    </div>
    )
}


import type { ILoginRequest, IRegisterRequest } from "../types/Interfaces";

// === CONFIGURACIÓN BASE ===
// URL de tu backend Spring Boot
const BASE_URL = "http://localhost:8081/api";

// === FUNCIÓN HELPER (Sin <T>, directa) ===
// 👇 Esta función hace las peticiones HTTP
async function fetchAPI(url: string, options?: any) {
  try {
    // 👇 Obtenemos el token guardado (si existe)
    const token = localStorage.getItem("token");
    
    // 👇 Hacemos la petición con fetch
    const res = await fetch(url, {
      headers: {
        "Content-Type": "application/json",
        // 👇 Si hay token, lo añadimos al header
        ...(token && { Authorization: `Bearer ${token}` }),
        ...options?.headers,
      },
      ...options,
    });

    // 👇 Si la respuesta no es OK, lanzamos error
    if (!res.ok) {
      const text = await res.text();
      throw new Error(text || "Error en la petición");
    }

    // 👇 Si es 204 (No Content), retornamos undefined
    if (res.status === 204) return undefined;

    // 👇 Devolvemos los datos como JSON
    return res.json();
  } catch (err) {
    console.error("fetchAPI error:", err, url);
    throw err;
  }
}

// === AUTENTICACIÓN ===

// 👇 Función de LOGIN
export const login = (data: ILoginRequest) =>
  fetchAPI(`${BASE_URL}/auth/login`, {
    method: "POST",
    body: JSON.stringify(data),
  });

// 👇 Función de REGISTER
export const register = (data: IRegisterRequest) =>
  fetchAPI(`${BASE_URL}/auth/register`, {
    method: "POST",
    body: JSON.stringify(data),
  });

// 👇 Función para obtener datos del usuario autenticado
export const getMe = () =>
  fetchAPI(`${BASE_URL}/users/me`);