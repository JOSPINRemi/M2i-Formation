import React, {useState} from 'react';
import {Button, Modal, StyleSheet, TextInput, View} from 'react-native';

export default function ModalInput(props) {
  const [productText, setProductText] = useState('');
  const [productPrice, setProductPrice] = useState('');

  function recupProductText(enteredText) {
    setProductText(enteredText);
  }
  function recupProductPrice(enteredPrice) {
    setProductPrice(enteredPrice);
  }
  function addElement() {
    props.addProduct(productText, productPrice);
  }
  return (
    <Modal visible={props.visible} animationType="slide">
      <View style={styles.container}>
        <TextInput
          style={styles.textInput}
          placeholder="Product exemple"
          value={productText}
          onChangeText={recupProductText}
        />
        <TextInput
          style={styles.textInput}
          placeholder="Product price"
          value={productPrice}
          onChangeText={recupProductPrice}
        />
        <View style={styles.buttonContainer}>
          <View style={styles.button}>
            <Button title="Add Product" onPress={addElement} />
          </View>
          <View style={styles.button}>
            <Button title="Cancel" onPress={props.closeModale} color="red" />
          </View>
        </View>
      </View>
    </Modal>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  textInput: {
    borderWidth: 1,
    borderColor: '#cccccc',
    width: '70%',
    padding: 8,
    borderRadius: 12,
  },
  buttonContainer: {
    marginTop: 16,
    flexDirection: 'row',
  },
  button: {
    width: '40%',
    marginHorizontal: 8,
  },
  image: {
    width: 100,
    height: 150,
  },
});
