import { useNavigate, useLocation } from 'react-router-dom'

export default function SubNavegacion() {
    const navigate = useNavigate()
    const location = useLocation()

    // Home activo en páginas de comida
    const rutasHome = ['/burger', '/bebidas', '/postre', '/salsas']

    const botones = [
        { id: 'home', texto: 'Home', ruta: '/burger' }, 
        { id: 'ajustes', texto: 'Ajustes', ruta: '/ajustes' },
        { id: 'informes', texto: 'Informes', ruta: '/informes' },
        { id: 'perfil', texto: 'Perfil', ruta: '/perfil' },
        { id: 'comprar', texto: 'Comprar', ruta: '/comprar' },
    ]

    return (
        <nav className="fixed bottom-0 left-0 z-50 w-full h-16 bg-[#F2E9DB] border-t border-gray-300">
            <div className="grid h-full max-w-5xl grid-cols-5 mx-auto font-medium gap-8">
                
                {botones.map((btn) => {
                    // Home activo en rutasHome, los demás solo en su ruta exacta
                    const isActive = btn.id === 'home' 
                        ? rutasHome.includes(location.pathname)
                        : location.pathname === btn.ruta
                    
                    return (
                        <button
                            key={btn.id}
                            type="button"
                            onClick={() => navigate(btn.ruta)}
                            className={`inline-flex flex-col items-center justify-center w-full h-full transition-colors group ${
                                isActive ? 'text-red-600' : 'text-gray-600 hover:text-red-600'
                            }`}
                            aria-label={`Ir a ${btn.texto}`}
                        >
                            <svg 
                                className={`w-6 h-6 mb-1 ${
                                    isActive ? 'text-red-600' : 'text-gray-600 group-hover:text-red-600'
                                }`} 
                                fill="none" 
                                viewBox="0 0 24 24" 
                                stroke="currentColor"
                            >
                                {btn.id === 'home' && (
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="m4 12 8-8 8 8M6 10.5V19a1 1 0 0 0 1 1h3v-3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v3h3a1 1 0 0 0 1-1v-8.5"/>
                                )}
                                {btn.id === 'ajustes' && (
                                    <path strokeLinecap="round" strokeWidth={2} d="M6 4v10m0 0a2 2 0 1 0 0 4m0-4a2 2 0 1 1 0 4m0 0v2m6-16v2m0 0a2 2 0 1 0 0 4m0-4a2 2 0 1 1 0 4m0 0v10m6-16v10m0 0a2 2 0 1 0 0 4m0-4a2 2 0 1 1 0 4m0 0v2"/>
                                )}
                                {btn.id === 'informes' && (
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M12 4v16m8-8H4"/>
                                )}
                                {btn.id === 'perfil' && (
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M12 21a9 9 0 1 0 0-18 9 9 0 0 0 0 18Zm0 0a8.949 8.949 0 0 0 4.951-1.488A3.987 3.987 0 0 0 13 16h-2a3.987 3.987 0 0 0-3.951 3.512A8.948 8.948 0 0 0 12 21Zm3-11a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"/>
                                )}
                                {btn.id === 'comprar' && (
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17 8H5m12 0a1 1 0 0 1 1 1v2.6M17 8l-4-4M5 8a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.6M5 8l4-4 4 4m6 4h-4a2 2 0 1 0 0 4h4a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1Z"/>
                                )}
                            </svg>
                        
                            <span className={`text-sm ${isActive ? 'text-red-600 font-semibold' : 'text-gray-600 group-hover:text-red-600'}`}>
                                {btn.texto}
                            </span>
                        </button>
                    )
                })}

            </div>
        </nav>
    )
}