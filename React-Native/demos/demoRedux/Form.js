import {Button, StyleSheet, Text, View} from 'react-native';
import React from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {addIds} from './store/redux/data';

export default function Form() {
  const dispatch = useDispatch();

  function getRandomInt() {
    return Math.floor(Math.random() * 100);
  }

  return (
    <View>
      <Button
        title="Ajout d'un ID random"
        onPress={() => dispatch(addIds({id: getRandomInt()}))}
      />
    </View>
  );
}

const styles = StyleSheet.create({});
