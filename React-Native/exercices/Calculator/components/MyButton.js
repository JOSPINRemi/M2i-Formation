import {Pressable, StyleSheet, Text, View} from 'react-native';
import React from 'react';

export default function MyButton({value, isRounded, isRound, onPress}) {
  return (
    <Pressable onPress={() => onPress(value)}>
      <View
        style={
          isRounded
            ? styles.roundedBackground
            : isRound
            ? styles.roundBackground
            : styles.defaultBackground
        }>
        <Text
          style={
            isRounded
              ? styles.roundedText
              : isRound
              ? styles.roundText
              : styles.defaultText
          }>
          {value}
        </Text>
      </View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  defaultText: {
    color: 'red',
    fontSize: 25,
    fontWeight: 'bold',
    alignSelf: 'center',
  },
  defaultBackground: {
    backgroundColor: 'blue',
    width: 72,
    height: 72,
    justifyContent: 'center',
    margin: 15,
  },
  roundedText: {
    color: 'white',
    fontSize: 25,
    fontWeight: 'bold',
    alignSelf: 'center',
  },
  roundedBackground: {
    backgroundColor: 'grey',
    borderRadius: 25,
    width: 72,
    height: 72,
    justifyContent: 'center',
    margin: 15,
  },
  roundText: {
    color: 'black',
    fontSize: 25,
    fontWeight: 'bold',
    alignSelf: 'center',
  },
  roundBackground: {
    backgroundColor: 'white',
    borderRadius: 50,
    width: 72,
    height: 72,
    justifyContent: 'center',
    margin: 15,
  },
});
