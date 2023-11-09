import {Button, StyleSheet, Text, View} from 'react-native';
import React from 'react';
import {useRoute} from '@react-navigation/native';

export default function ProductDetails() {
  const route = useRoute();
  const product = route.params.item;

  return (
    <View>
      <View style={styles.productDetailsBlock}>
        <Text style={styles.productDetailsLabel}>Name :</Text>
        <Text style={styles.productDetailsValue}>{product.name}</Text>
      </View>
      <View style={styles.productDetailsBlock}>
        <Text style={styles.productDetailsLabel}>Price :</Text>
        <Text style={styles.productDetailsValue}>{product.price} €</Text>
      </View>
      <View style={styles.buttons}>
        <Button title="Edit" />
        <Button title="Delete" />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  productDetailsBlock: {flexDirection: 'row', gap: 5},
  productDetailsLabel: {
    color: '#000',
    textTransform: 'uppercase',
    fontWeight: 'bold',
    fontStyle: 'italic',
  },
  productDetailsValue: {color: '#3E3E3E'},
  buttons: {
    flexDirection: 'row',
    justifyContent: 'space-around',
  },
});
