import {Image, FlatList, StyleSheet, Text, View} from 'react-native';
import React, {useEffect} from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {fetchDetails} from './Pokemons/pokemonsSlice';

export default function PokemonDetailsScreen({route}) {
  const pokemon = route.params.pokemon;
  const backgroundColor = route.params.bgColor;
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchDetails(pokemon.species.url));
  }, []);

  const allDetails = useSelector(state => state.pokemons.pokemonDetails);

  useEffect(() => {
    dispatch(fetchEvolves(allDetails.evolution_chain));
  }, [allDetails]);

  const pokemonEvolves = useSelector(state => state.pokemons.pokemonEvolves);

  return (
    <View>
      <View style={{backgroundColor: backgroundColor}}>
        <Text style={styles.textHeader}>{pokemon.name}</Text>
        <FlatList
          data={pokemon.types}
          renderItem={({item}) => {
            return <Text style={styles.textHeader}>{item.type.name}</Text>;
          }}
          keyExtractor={(item, index) => {
            return index;
          }}
        />
        <Image
          source={{uri: pokemon.sprites.front_default}}
          style={styles.image}
        />
      </View>
      <View style={styles.section}>
        <Text style={styles.sectionTitle}>Détails</Text>
        {allDetails && (
          <Text style={{color: '#000'}}>
            {
              // console.log(allDetails.flavor_text_entries[0].flavor_text)
              // allDetails.flavor_text_entries[0].flavor_text
              allDetails.flavor_text_entries.find(
                entries => entries.language.name == 'en',
              ).flavor_text
            }
          </Text>
        )}
        <View>
          <Text>Height</Text>
          <Text>
            {pokemon.height / 0.254}({pokemon.height / 10} cm)
          </Text>
        </View>
        <View>
          <Text>Height</Text>
          <Text>
            {(pokemon.weight / 10) * 2.20462262} lbs({pokemon.weight / 10} kg)
          </Text>
        </View>
      </View>
      <View style={styles.section}>
        <Text style={styles.sectionTitle}>Chaîne d'évolutions</Text>
        <Text>
          {pokemonEvolves.chain.evolves_to[0].evolves_to[0].species.name}
        </Text>
        <Text>{pokemonEvolves.chain.species.name}</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  textHeader: {
    color: '#fff',
  },
  image: {
    width: 250,
    height: 250,
  },
  section: {
    margin: 10,
  },
  sectionTitle: {
    color: '#000',
    fontSize: 20,
    fontWeight: 'bold',
  },
});
