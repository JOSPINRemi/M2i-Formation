import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import axios from 'axios';
const ENDPOINT = 'https://pokeapi.co/api/v2/pokemon';

export const fetchPokemons = createAsyncThunk(
  'pokemons/fetchPokemons',
  async () => {
    // const response = await axios.get(`${ENDPOINT}?offset=10&limit=50`);
    const response = await axios.get(`${ENDPOINT}?offset=0&limit=1`);
    return response.data.results;
  },
);

export const fetchPokemon = createAsyncThunk(
  'pokemons/fetchPokemon',
  async url => {
    const response = await axios.get(url);
    return response.data;
  },
);

const pokemonsSlice = createSlice({
  name: 'pokemons',
  initialState: {
    pokemonList: [],
    pokemons: [],
    isLoading: false,
    error: null,
  },
  extraReducers: builder => {
    builder.addCase(fetchPokemons.pending, state => {
      state.isLoading = true;
      state.error = null;
      state.pokemonList = [];
    });
    builder.addCase(fetchPokemons.rejected, (state, action) => {
      state.isLoading = false;
      state.error = action.payload;
    });
    builder.addCase(fetchPokemons.fulfilled, (state, action) => {
      state.isLoading = false;
      state.pokemonList = action.payload;
    });

    builder.addCase(fetchPokemon.pending, state => {
      state.isLoading = true;
      state.error = null;
    });
    builder.addCase(fetchPokemon.rejected, (state, action) => {
      state.isLoading = false;
      state.error = action.payload;
    });
    builder.addCase(fetchPokemon.fulfilled, (state, action) => {
      state.isLoading = false;
      state.pokemons.push(action.payload);
    });
  },
});

export default pokemonsSlice.reducer;
