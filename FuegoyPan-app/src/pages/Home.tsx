import { Link } from 'react-router-dom'
import logo from '../assets/logo.png'

export default function Home() {
    return (
        <section className='relative h-screen w-full bg-[url(https://images.pexels.com/photos/2983101/pexels-photo-2983101.jpeg?cs=srgb&dl=pexels-jonathan-borba-2983101.jpg&fm=jpg)] bg-cover bg-center'>
            <div className='flex flex-col items-center justify-center h-full gap-8'>
                <img src={logo} alt="Logo" className='w-75 h-45 rounded-full' />
                <Link to='/inicio' className='bg-red-600 text-white px-12 py-4 rounded-full font-bold text-lg hover:bg-red-700 transition shadow-lg w-64 text-center'>
                    Inicia Sesión
                </Link>
            </div>
        </section>
    )
}
