import {Pressable, FlatList, StyleSheet, Text, View, Image} from 'react-native';
import React, {useEffect} from 'react';
import {useNavigation} from '@react-navigation/native';

export default function Card({item}) {
  const navigation = useNavigation();

  function getBackgroundColor(type) {
    switch (type) {
      case 'normal':
        return '#A8A878';
        break;
      case 'fighting':
        return '#C03028';
        break;
      case 'flying':
        return '#A890F0';
        break;
      case 'poison':
        return '#A040A0';
        break;
      case 'ground':
        return '#E0C068';
        break;
      case 'rock':
        return '#B8A038';
        break;
      case 'bug':
        return '#A8B820';
        break;
      case 'ghost':
        return '#705898';
        break;
      case 'steel':
        return '#B8B8D0';
        break;
      case 'fire':
        return '#F08030';
        break;
      case 'water':
        return '#6890F0';
        break;
      case 'grass':
        return '#78C850';
        break;
      case 'electric':
        return '#F8D030';
        break;
      case 'psychic':
        return '#F85888';
        break;
      case 'ice':
        return '#98D8D8';
        break;
      case 'dragon':
        return '#7038F8';
        break;
      case 'dark':
        return '#705848';
        break;
      case 'fairy':
        return '#EE99AC';
        break;
    }
  }

  return (
    <Pressable
      onPress={() =>
        navigation.navigate('PokemonDetails', {
          pokemon: item,
          bgColor: getBackgroundColor(item.types[0].type.name),
        })
      }>
      <View
        style={[
          styles.container,
          {
            backgroundColor: getBackgroundColor(item.types[0].type.name),
          },
        ]}>
        <View>
          <Text style={styles.label}>name : </Text>
          <Text style={styles.text}>{item.name}</Text>
        </View>
        <View>
          <Text style={styles.label}>types : </Text>
          <FlatList
            data={item.types}
            renderItem={({item}) => {
              return <Text style={styles.text}>{item.type.name}</Text>;
            }}
            keyExtractor={(item, index) => {
              return index;
            }}
          />
        </View>
        <Image
          source={{uri: item.sprites.front_default}}
          style={styles.image}
        />
      </View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  container: {
    padding: 10,
    borderRadius: 30,
    alignItems: 'center',
    margin: 5,
  },
  label: {
    color: '#000',
    fontWeight: 'bold',
    textTransform: 'uppercase',
  },
  text: {
    color: '#fff',
  },
  image: {
    width: 150,
    height: 150,
  },
});
