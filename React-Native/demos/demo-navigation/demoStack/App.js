import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import React from 'react';
import {StyleSheet} from 'react-native';
import PageA from './components/PageA';
import PageB from './components/PageB';
import PageC from './components/PageC';

/**
 * Package nécessaire pour la navigation :
 * npm install @react-navigation/native
 * npm install react-native-screens react-native-safe-area-context
 * npm install @react-navigation/native-stack
 */

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="PageC">
        <Stack.Screen
          name="PageA"
          component={PageA}
          options={{title: 'Ma page A'}}
        />
        <Stack.Screen name="PageB" component={PageB} />
        <Stack.Screen
          name="PageC"
          component={PageC}
          options={{headerShown: false}}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({});
