import {useRoute} from '@react-navigation/native';
import React from 'react';
import {FlatList, Image, StyleSheet, Text, View} from 'react-native';
import {MEALS} from '../projet/data/data.js';

export default function MealDetailsScreen() {
  const route = useRoute();
  const id = route.params.id;
  const meal = MEALS.find(meal => meal.id === id);

  return (
    <View>
      <Image source={{uri: meal.imageUrl}} style={styles.image} />
      <Text style={styles.title}>{meal.title}</Text>
      <Text style={styles.details}>
        {meal.duration}m {meal.complexity} {meal.affordability}
      </Text>
      <View style={styles.block}>
        <Text style={styles.blockTitle}>Ingredients</Text>
        <View style={{flexDirection: 'row'}}>
          <View style={{flex: 1, height: 3, backgroundColor: '#c8ad7f'}}></View>
        </View>
        <FlatList
          data={meal.ingredients}
          renderItem={({item}) => {
            return (
              <View style={styles.FlatListItem}>
                <Text>{item}</Text>
              </View>
            );
          }}
          keyExtractor={(item, index) => {
            return index;
          }}
        />
      </View>
      <View style={styles.block}>
        <Text style={styles.blockTitle}>Steps</Text>
        <View style={{flexDirection: 'row'}}>
          <View style={{flex: 1, height: 3, backgroundColor: '#c8ad7f'}}></View>
        </View>
        <FlatList
          data={meal.steps}
          renderItem={({item}) => {
            return (
              <View style={styles.FlatListItem}>
                <Text>{item}</Text>
              </View>
            );
          }}
          keyExtractor={(item, index) => {
            return index;
          }}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  image: {
    width: '100%',
    height: 300,
  },
  title: {
    color: '#000',
    fontSize: 30,
    textAlign: 'center',
  },
  details: {textTransform: 'uppercase', textAlign: 'center'},
  block: {margin: 5},
  blockTitle: {fontSize: 20, color: '#c8ad7f', textAlign: 'center'},
  FlatListItem: {
    backgroundColor: '#c8ad7f',
    margin: 5,
    borderRadius: 3,
    alignItems: 'center',
  },
});
