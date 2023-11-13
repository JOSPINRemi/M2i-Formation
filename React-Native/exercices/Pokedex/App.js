import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import React from 'react';
import {Provider} from 'react-redux';
import {StyleSheet} from 'react-native';
import HomeScreen from './screens/HomeScreen';
import PokemonListScreen from './screens/PokemonListScreen';
import PokedexScreen from './screens/PokedexScreen';
import store from './store.js';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator>
          <Stack.Screen
            name="Home"
            component={HomeScreen}
            options={{headerShown: false}}
          />
          <Stack.Screen name="PokemonList" component={PokemonListScreen} />
          <Stack.Screen name="Pokedex" component={PokedexScreen} />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
}

const styles = StyleSheet.create({});
