import {useNavigation} from '@react-navigation/native';
import React from 'react';
import {FlatList, StyleSheet, View} from 'react-native';
import {CATEGORIES} from '../projet/data/data.js';
import CategoryButton from './components/CategoryButton.js';

export default function HomeScreen() {
  const navigation = useNavigation();
  return (
    <View>
      <FlatList
        data={CATEGORIES}
        renderItem={({item}) => {
          return (
            <CategoryButton
              title={item.title}
              bgColor={item.color}
              onPress={() => navigation.navigate('Meals', {id: item.id})}
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
