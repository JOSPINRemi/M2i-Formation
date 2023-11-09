import {Button, StyleSheet, Text, View} from 'react-native';
import React, {useState} from 'react';
import AsyncStorage from '@react-native-async-storage/async-storage';

export default function App() {
  const [value, setValue] = useState({nom: '', prenom: ''});

  // // Stockage String
  // const addData = async () => {
  //   try {
  //     await AsyncStorage.setItem('storageKey', 'toto');
  //   } catch (error) {
  //     console.log(error);
  //   }
  // };

  // const getData = async () => {
  //   try {
  //     const maValue = await AsyncStorage.getItem('storageKey');
  //     if (maValue !== null) {
  //       setValue({nom: maValue, prenom: maValue});
  //     } else {
  //       throw new Error('No data in AsyncStorage');
  //     }
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // const deleteData = async () => {
  //   try {
  //     const maValue = await AsyncStorage.removeItem('storageKey');
  //     setValue({nom: '', prenom: ''});
  //   } catch (error) {
  //     console.error(error);
  //   }
  // };

  // Stockage Objet
  const addData = async () => {
    try {
      await AsyncStorage.setItem(
        'storageKeyObject',
        JSON.stringify({nom: 'toto', prenom: 'titi'}),
      );
    } catch (error) {
      console.log(error);
    }
  };

  const getData = async () => {
    try {
      const maValue = await AsyncStorage.getItem('storageKeyObject');
      if (maValue !== null) {
        setValue(JSON.parse(maValue));
      } else {
        throw new Error('No data in AsyncStorage');
      }
    } catch (error) {
      console.error(error);
    }
  };

  const deleteData = async () => {
    try {
      const maValue = await AsyncStorage.removeItem('storageKeyObject');
      setValue({nom: '', prenom: ''});
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <View>
      <Text>Nom: {value.nom}</Text>
      <Text>Prénom: {value.prenom}</Text>
      <View style={styles.buttons}>
        <Button title="add data" onPress={addData} />
        <Button title="get data" onPress={getData} />
        <Button title="delete data" onPress={deleteData} />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  buttons: {
    flexDirection: 'row',
    justifyContent: 'space-around',
  },
});
