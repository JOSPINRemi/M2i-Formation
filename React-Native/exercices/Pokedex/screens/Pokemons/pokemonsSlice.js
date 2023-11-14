import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import axios from 'axios';
const ENDPOINT = 'https://pokeapi.co/api/v2/pokemon';

export const fetchPokemonURLLIst = createAsyncThunk(
  'pokemons/fetchPokemonURLLIst',
  async () => {
    // const response = await axios.get(`${ENDPOINT}?offset=0&limit=2`);
    const response = await axios.get(`${ENDPOINT}?offset=10&limit=50`);
    return response.data.results;
  },
);

export const fetchPokemons = createAsyncThunk(
  'pokemons/fetchPokemons',
  async urlList => {
    const pokemons = await Promise.all(
      urlList.map(async url => {
        const response = await axios.get(url);
        // console.log('response.data');
        // console.log(response.data);
        return response.data;
      }),
    );
    // console.log('pokemons');
    // console.log(pokemons);
    return pokemons;
  },
);

export const fetchDetails = createAsyncThunk(
  'pokemons/fetchDetails',
  async url => {
    const response = await axios.get(url);
    return response.data;
  },
);

export const fetchEvolves = createAsyncThunk(
  'pokemons/fetchEvolves',
  async url => {
    const response = await axios.get(url);
    return response.data;
  },
);

const pokemonsSlice = createSlice({
  name: 'pokemons',
  initialState: {
    pokemonURLList: [],
    pokemons: [],
    pokemonDetails: [],
    pokemonEvolves: [],
    isLoading: false,
    error: null,
  },
  extraReducers: builder => {
    builder.addCase(fetchPokemonURLLIst.pending, state => {
      state.isLoading = true;
      state.error = null;
      state.pokemonURLList = [];
    });
    builder.addCase(fetchPokemonURLLIst.rejected, (state, action) => {
      state.isLoading = false;
      state.error = action.payload;
    });
    builder.addCase(fetchPokemonURLLIst.fulfilled, (state, action) => {
      state.isLoading = false;
      state.pokemonURLList = action.payload;
      // console.log('fetchPokemonURLLIst')
      // console.log(action.payload);
    });

    builder.addCase(fetchPokemons.pending, state => {
      state.isLoading = true;
      state.error = null;
    });
    builder.addCase(fetchPokemons.rejected, (state, action) => {
      state.isLoading = false;
      state.error = action.payload;
    });
    builder.addCase(fetchPokemons.fulfilled, (state, action) => {
      state.isLoading = false;
      if (
        !state.pokemons.find(pokemon => pokemon.name === action.payload.name)
      ) {
        state.pokemons = action.payload;
      }
    });

    builder.addCase(fetchDetails.fulfilled, (state, action) => {
      state.pokemonDetails = action.payload;
    });

    builder.addCase(fetchEvolves.fulfilled, (state, action) => {
      state.pokemonEvolves = action.payload;
    });
  },
});

export default pokemonsSlice.reducer;
