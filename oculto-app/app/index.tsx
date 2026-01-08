// screens/OcultoMenuScreen.tsx o App.tsx
import React, { useState } from 'react';
import { ScrollView, Text, TouchableOpacity, View } from 'react-native';
import CategoryButton from '@/components/CategoryButton';
import ProductButton from '@/components/ProductButton';
import { foodList } from '@/data/Data';


// Mapeo de categoría a nombre (según lo definido antes)
const categoryNames: Record<number, string> = {
  1: "Hamburguesas",
  2: "Acompañamientos",
  3: "Bebidas",
  4: "Postres / Extras",
};

export default function OcultoMenuScreen() {
  const [selectedCategory, setSelectedCategory] = useState<number | null>(null);

  // Obtener productos de la categoría seleccionada
  const filteredProducts = selectedCategory
    ? foodList.filter(item => item.cat === selectedCategory)
    : [];

  // Obtener categorías únicas (por número)
  const uniqueCategories = [...new Set(foodList.map(item => item.cat))].sort();

  const handleBack = () => setSelectedCategory(null);

  return (
    <ScrollView className="flex-1 bg-neutral-900 p-5">
      {!selectedCategory ? (
        <>
          <View className="items-center mb-8 mt-4">
            <Text className="text-3xl font-bold text-red-800 tracking-wide">OCULTO</Text>
            <Text className="text-gray-500 text-sm mt-1">Elige tu pecado</Text>
          </View>

          {uniqueCategories.map(catId => (
            <CategoryButton
              key={catId}
              label={categoryNames[catId] || `Categoría ${catId}`}
              onPress={() => setSelectedCategory(catId)}
            />
          ))}
        </>
      ) : (
        <>
          <TouchableOpacity onPress={handleBack} className="mb-5">
            <Text className="text-red-600 font-medium">← Volver</Text>
          </TouchableOpacity>

          <Text className="text-2xl font-bold text-gray-100 mb-5">
            {categoryNames[selectedCategory] || "Menú"}
          </Text>

          {filteredProducts.map((item, index) => (
            <ProductButton
              key={index}
              name={item.name}
              kcal={item.kcal}
              icon={item.icon}
              onPress={() => {
                // Aquí podrías añadir al carrito, mostrar detalle, etc.
                console.log("Seleccionado:", item.name);
              }}
            />
          ))}
        </>
      )}
    </ScrollView>
  );
}