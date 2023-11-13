import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import React from 'react';
import {StyleSheet} from 'react-native';
import HomeScreen from './screens/HomeScreen';
import MealsScreen from './screens/MealsScreen';
import MealDetailsScreen from './screens/MealDetailsScreen';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          name="Home"
          component={HomeScreen}
          options={{title: 'All Categories'}}
        />
        <Stack.Screen
          name="Meals"
          component={MealsScreen}
          options={{title: 'MealsOverview'}}
        />
        <Stack.Screen
          name="MealDetails"
          component={MealDetailsScreen}
          options={{title: 'About the Meal'}}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({});
