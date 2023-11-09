import {useNavigation} from '@react-navigation/native';
import React, {useState} from 'react';
import {FlatList, StyleSheet, View} from 'react-native';
import ProductItem from './components/ProductItem';
import RoundButton from './components/RoundButton';
import ModalInput from './components/ModalInput';

export default function ProductList() {
  const navigation = useNavigation();
  const [modalIsVisible, setModalIsVisible] = useState(false);
  const [products, setProducts] = useState([
    {name: 'Pomme', price: 1.5, id: Math.random().toString()},
  ]);

  function addProduct(productName, productPrice) {
    setProducts(productsCurrent => [
      ...productsCurrent,
      {name: productName, price: productPrice, id: Math.random().toString()},
    ]);
    setModalIsVisible(false);
  }

  function closeModale() {
    setModalIsVisible(false);
  }

  function openModale() {
    setModalIsVisible(true);
  }

  return (
    <View>
      <ModalInput
        visible={modalIsVisible}
        closeModale={closeModale}
        addProduct={addProduct}
      />
      <FlatList
        data={products}
        renderItem={({item}) => {
          return (
            <ProductItem
              title={item.name}
              onPress={() => navigation.navigate('Details', {item})}
            />
          );
        }}
        keyExtractor={(item, index) => {
          return index;
        }}
      />
      <RoundButton title="+" onPress={openModale} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 20,
    paddingHorizontal: 16,
  },
});
