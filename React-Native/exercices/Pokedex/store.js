import {configureStore} from '@reduxjs/toolkit';
import pokemonsSlice from './screens/Pokemons/pokemonsSlice.js';

export default configureStore({
  reducer: {
    pokemons: pokemonsSlice,
  },
});
