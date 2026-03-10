import { Route, Routes } from "react-router"
import Home from './pages/Home'
import Burger from "./pages/Burger"
import Inicio from "./pages/Login"

function App() {

  return (
    <>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/inicio' element={<Inicio/>}/>
        <Route path='/burger' element={<Burger/>}/>
      </Routes>
    </>
  )
}

export default App
