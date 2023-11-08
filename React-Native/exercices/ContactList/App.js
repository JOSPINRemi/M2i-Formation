import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import React from 'react';
import { StyleSheet } from 'react-native';
import DetailsPage from './components/DetailsPage';
import HomePage from './components/HomePage';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen
          name="Home"
          component={HomePage}
          options={{headerShown: false}}
        />
        <Stack.Screen
          name="Details"
          component={DetailsPage}
          options={{title: 'Details du contact'}}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({});
