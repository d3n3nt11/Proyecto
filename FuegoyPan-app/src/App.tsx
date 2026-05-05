import { Route, Routes } from "react-router"
import Home from './pages/Home'
import Burger from "./pages/Burger"
import Inicio from "./pages/Login"
import Bebidas from "./pages/Bebidas"
import Postre from "./pages/Postre"
import Salsas from "./pages/Salsas"
import Ajustes from "./pages/Ajustes"
import Informes from "./pages/Informes"
import Comprar from "./pages/Comprar"
import Perfil from "./pages/Perfil"
import ConfigurarInventario from "./pages/ajustes/ConfigurarInventario"
import ReponerInventario from "./pages/ajustes/ReponerInventario"
import VerInventario from "./pages/ajustes/VerInventario"
import Pago from "./pages/Pago"
import Success from "./pages/Succes"
import Cancel from "./pages/Cancel"
function App() {
  return (
    <>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/inicio' element={<Inicio/>}/>
        <Route path='/burger' element={<Burger/>}/>
        <Route path="/bebidas" element={<Bebidas/>}/>
        <Route path="/salsas" element={<Salsas/>}/>
        <Route path="/postre" element={<Postre/>}/>
        <Route path="/ajustes" element={<Ajustes/>}/>
        <Route path="/informes" element={<Informes/>}/>
        <Route path="/comprar" element={<Comprar/>}/>
        <Route path="/pago" element={<Pago />} />
        <Route path="/success" element={<Success/>} />
        <Route path="/cancel" element={<Cancel/>} />
        <Route path="/perfil" element={<Perfil/>}/>
        <Route path="/ajustes/VerInventario" element={<VerInventario/>}/>
        <Route path="/ajustes/ReponerInventario" element={<ReponerInventario/>}/>
        <Route path="/ajustes/ConfigurarPorcentaje" element={<ConfigurarInventario/>}/>
      </Routes>
    </>
  )
}

export default App
