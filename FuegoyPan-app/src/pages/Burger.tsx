import { useState } from "react";
import CardFood from "../Components/CardFood";

export default function Burger() {

  const [search, setSearch] = useState<string>("");


  return (
    <div className="bg-[#F2E9DB] min-h-screen flex flex-col items-center justify-start py-10">
      <img src="src/assets/logo.png" alt="logo" className="w-75 h-45 rounded-full"/>
      <h1 className="text-2xl text-white font-bold">¿Qué desea el cliente?</h1>

      <CardFood/>
    </div>
  )
}
