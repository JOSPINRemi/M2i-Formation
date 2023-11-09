import {Pressable, StyleSheet, Text, View} from 'react-native';
import React from 'react';

export default function RoundButton({title, onPress}) {
  return (
    <Pressable onPress={onPress}>
      <View style={[styles.text, styles.shape]}>
        <Text>{title}</Text>
      </View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  text: {alignItems: 'center', justifyContent: 'center'},
  shape: {
    backgroundColor: 'lightgreen',
    borderRadius: 50,
  },
});
