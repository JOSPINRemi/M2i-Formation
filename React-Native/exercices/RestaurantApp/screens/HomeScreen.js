import {FlatList, StyleSheet, Text, View} from 'react-native';
import React from 'react';
import {CATEGORIES} from '../projet/data/data.js';
import CategoryButton from './components/CategoryButton.js';
import {useNavigation} from '@react-navigation/native';

export default function HomeScreen() {
  const navigation = useNavigation();
  return (
    <View>
      <FlatList
        data={CATEGORIES}
        renderItem={({item}) => {
          return (
            // <View>
            //   <Text>{item.title}</Text>
            // </View>
            <CategoryButton
              title={item.title}
              bgColor={item.color}
              onPress={() => navigation.navigate('')}
            />
          );
        }}
        keyExtractor={(item, index) => {
          return item.id;
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({});
