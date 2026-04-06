import { Route, Routes } from "react-router"
import Home from './pages/Home'
import Burger from "./pages/Burger"
import Inicio from "./pages/Login"
import Bebidas from "./pages/Bebidas"
import Postre from "./pages/Postre"
import Salsas from "./pages/Salsas"
import TestSale from "./pages/TestSale"
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
        <Route path="/test" element={<TestSale/>}/>
      </Routes>
    </>
  )
}

export default App
