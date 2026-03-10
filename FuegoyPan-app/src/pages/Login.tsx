import logo from '../assets/logo.png'

export default function Login() {
    return (
        <div className='min-h-screen flex flex-col items-center justify-center bg-[url(https://images.pexels.com/photos/2983101/pexels-photo-2983101.jpeg?cs=srgb&dl=pexels-jonathan-borba-2983101.jpg&fm=jpg)] bg-cover bg-center'>
            <div className='mb-8'>
                <img src={logo} alt="Logo" className='w-75 h-45 rounded-full ' />
            </div>
            <div className='bg-white rounded-3xl shadow-2xl p-8 w-96'>
                <h2 className='text-2xl font-bold text-center text-gray-800 mb-8'>
                    Bienvenido a Fuego y Pan
                </h2>
                <form>
                    <div className='mb-6'>
                        <input type='email' placeholder='E-mail' className='w-full px-4 py-3 border border-gray-300 rounded-lg'/>
                    </div>
                    <div className='mb-6'>
                        <input type='password' placeholder='Contraseña' className='w-full px-4 py-3 border border-gray-300 rounded-lg'/>
                    </div>
                    <button type='submit' className='w-full bg-red-600 text-white font-bold py-4 rounded-full hover:bg-red-700 transition duration-300 shadow-lg'>
                        Inicia Sesión
                    </button>
                </form>
            </div>
        </div>
    )
}
