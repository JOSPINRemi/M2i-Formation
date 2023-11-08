import {FlatList, StyleSheet, Text, View} from 'react-native';
import React from 'react';
import ProductItem from './ProductItem';

export default function ProductList({navigation}) {
  const products = [];

  return (
    <View>
      <FlatList
        data={products}
        renderItem={({item}) => {
          return (
            <ProductItem
              title=""
              onPress={() => navigation.navigate('Details', {item})}
            />
          );
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({});
