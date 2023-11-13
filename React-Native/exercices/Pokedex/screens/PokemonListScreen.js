import {FlatList, StyleSheet, Text, View} from 'react-native';
import React, {useEffect} from 'react';
import {useSelector, useDispatch} from 'react-redux';
import {fetchPokemons, fetchPokemon} from './Pokemons/pokemonsSlice';

export default function PokemonListScreen() {
  const dispatch = useDispatch();
  const pokemonList = useSelector(state => state.pokemons.pokemonList);

  useEffect(() => {
    dispatch(fetchPokemons());
    // console.log(pokemonList);
  }, []);

  useEffect(() => {
    for (let i = 0; i < pokemonList.length; i++) {
      dispatch(fetchPokemon(pokemonList[i].url));
    }
    // console.log(pokemons);
  }, [pokemonList]);

  const pokemons = useSelector(state => state.pokemons.pokemons);
  return (
    <View>
      {/* <FlatList data={pokemons} /> */}
      <Text>{pokemons.name}</Text>
    </View>
  );
}

const styles = StyleSheet.create({});
