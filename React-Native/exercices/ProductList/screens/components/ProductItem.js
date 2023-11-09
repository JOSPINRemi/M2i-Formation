import {Pressable, StyleSheet, Text, View} from 'react-native';
import React from 'react';

export default function ProductItem({title, onPress}) {
  return (
    <Pressable onPress={onPress}>
      <View>
        <Text style={styles.productName}>{title}</Text>
      </View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  productName: {
    color: '#3E3E3E',
  },
});
