import {FlatList, StyleSheet, Text, View} from 'react-native';
import React, {useEffect} from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {fetchPokemonURLLIst, fetchPokemons} from './Pokemons/pokemonsSlice';
import Card from './components/Card';

export default function PokemonListScreen() {
  const dispatch = useDispatch();
  const pokemonURLList = useSelector(state => state.pokemons.pokemonURLList);

  useEffect(() => {
    dispatch(fetchPokemonURLLIst());
    // console.log(pokemonURLList);
  }, []);

  useEffect(() => {
    if (pokemonURLList.length > 1) {
      const urlList = pokemonURLList.map(el => el.url);
      // console.log('urlList');
      // console.log(urlList);
      dispatch(fetchPokemons(urlList));
    }
  }, [pokemonURLList]);

  const pokemons = useSelector(state => state.pokemons.pokemons);
  console.log(pokemons);
  return (
    <View>
      <FlatList
        data={pokemons}
        renderItem={({item}) => {
          return <Card item={item} />;
        }}
        keyExtractor={(item, index) => {
          return item.id;
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({});
