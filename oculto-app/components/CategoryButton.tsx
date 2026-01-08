// components/CategoryButton.tsx
import React from 'react';
import { TouchableOpacity, Text } from 'react-native';

interface CategoryButtonProps {
  label: string;
  onPress: () => void;
}

export default function CategoryButton({ label, onPress }: CategoryButtonProps) {
  return (
    <TouchableOpacity
      className="bg-neutral-800 p-4 mb-3 rounded-xl border border-neutral-700"
      onPress={onPress}
    >
      <Text className="text-gray-200 font-semibold text-lg">{label}</Text>
    </TouchableOpacity>
  );
}