// components/ProductButton.tsx
import React from 'react';
import { TouchableOpacity, Text, View, Image } from 'react-native';

interface ProductButtonProps {
  name: string;
  kcal: number;
  icon: string;
  onPress: () => void;
}

export default function ProductButton({ name, kcal, icon, onPress }: ProductButtonProps) {
  return (
    <TouchableOpacity
      className="flex-row items-center bg-neutral-800 p-4 mb-3 rounded-lg border-l-4 border-red-800"
      onPress={onPress}
    >
      <Image
        source={{ uri: icon.trim() }}
        className="w-12 h-12 mr-4"
        resizeMode="contain"
      />
      <View className="flex-1">
        <Text className="text-yellow-50 font-bold">{name}</Text>
        <Text className="text-gray-400 text-sm">{kcal} kcal</Text>
      </View>
    </TouchableOpacity>
  );
}