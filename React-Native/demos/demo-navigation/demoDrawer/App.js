import {StyleSheet, Text, View} from 'react-native';
import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {createDrawerNavigator} from '@react-navigation/drawer';
import PageA from './screens/PageA';
import PageB from './screens/PageB';

/**
 * Package nécessaire pour la navigation :
 * npm install @react-navigation/native
 * npm install react-native-screens react-native-safe-area-context
 * npm install @react-navigation/drawer
 * npm install react-native-gesture-handler
 * npm install react-native-reanimated
 */

const Drawer = createDrawerNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Drawer.Navigator>
        <Drawer.Screen name="PageA" component={PageA} />
        <Drawer.Screen name="PageB" component={PageB} />
      </Drawer.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({});
