import {useNavigation} from '@react-navigation/native';
import React from 'react';
import {Button, StyleSheet, Text, View} from 'react-native';

export default function HomeScreen() {
  const navigation = useNavigation();

  return (
    <View style={styles.container}>
      <Text style={styles.text}>Attrapez les tous, pokémon</Text>
      <View style={styles.buttons}>
        <Button
          title="Lister les pokémons"
          onPress={() => navigation.navigate('PokemonList')}
        />
        <Button
          title="Afficher le pokédex"
          onPress={() => navigation.navigate('Pokedex')}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  text: {
    textAlign: 'center',
    textTransform: 'uppercase',
    fontWeight: 'bold',
  },
  buttons: {
    flexDirection: 'row',
    justifyContent: 'space-around',
  },
});
