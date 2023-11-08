import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {NavigationContainer} from '@react-navigation/native';
import React from 'react';
import {StyleSheet} from 'react-native';
import About from './screens/About';
import Contact from './screens/Contact';
import Home from './screens/Home';

/**
 * Package nécessaire pour la navigation :
 * npm install @react-navigation/native
 * npm install react-native-screens react-native-safe-area-context
 * npm install @react-navigation/bottom-tabs
 */

const Tab = createBottomTabNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Tab.Navigator
        screenOptions={{
          tabBarIconStyle: {display: 'none'},
          tabBarLabelPosition: 'beside-icon',
        }}>
        <Tab.Screen name="Home" component={Home} />
        <Tab.Screen name="Contact" component={Contact} />
        <Tab.Screen name="About" component={About} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({});
