import {Pressable, StyleSheet, Text, View} from 'react-native';
import React from 'react';

export default function CategoryButton({title, onPress, bgColor}) {
  return (
    <Pressable onPress={onPress}>
      <View
        style={{
          width: '50%',
          height: 100,
          justifyContent: 'center',
          alignItems: 'center',
          borderRadius: 25,
          backgroundColor: bgColor,
          margin: 5,
        }}>
        <Text style={styles.text}>{title}</Text>
      </View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  text: {color: '#fff'},
});
