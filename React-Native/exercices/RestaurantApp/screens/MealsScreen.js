import {useNavigation, useRoute} from '@react-navigation/native';
import React from 'react';
import {Pressable, FlatList, Image, StyleSheet, Text, View} from 'react-native';
import {MEALS} from '../projet/data/data.js';

export default function MealsScreen() {
  const navigation = useNavigation();
  const route = useRoute();
  const id = route.params.id;
  return (
    <View>
      <FlatList
        data={MEALS}
        renderItem={({item}) => {
          if (item.categoryIds.includes(id)) {
            return (
              <Pressable
                onPress={() =>
                  navigation.navigate('MealDetails', {id: item.id})
                }>
                <View style={styles.MealItem}>
                  <Image source={{uri: item.imageUrl}} style={styles.image} />
                  <Text style={styles.title}>{item.title}</Text>
                  <Text style={styles.details}>
                    {item.duration}m {item.complexity} {item.affordability}
                  </Text>
                </View>
              </Pressable>
            );
          }
        }}
        keyExtractor={(item, index) => {
          return item.id;
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  image: {
    width: '100%',
    height: 300,
  },
  title: {color: 'grey', fontSize: 20},
  details: {
    textTransform: 'uppercase',
  },
  MealItem: {
    alignItems: 'center',
    justifyContent: 'center',
    margin: 5,
  },
});
