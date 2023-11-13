import React from 'react';
import {Button, StyleSheet, View} from 'react-native';
import {useNavigation} from '@react-navigation/native';

export default function HomeScreen() {
  const navigation = useNavigation();

  return (
    <View style={styles.container}>
      <Button
        title="Lister les pokémons"
        onPress={() => navigation.navigate('PokemonList')}
      />
      <Button
        title="Afficher le pokédex"
        onPress={() => navigation.navigate('Pokedex')}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    justifyContent: 'space-around',
  },
});
