import {Button, StyleSheet, Text, View} from 'react-native';
import React from 'react';

export default function PageC({navigation}) {
  return (
    <View>
      <View style={styles.view}>
        <Text>On va mettre un lien vers la page A !!!</Text>
        <Button
          title="Go to Page A"
          onPress={() => navigation.navigate('PageA', {message: 'Hello'})}
        />
      </View>
      <View style={styles.view}>
        <Text>On va mettre un lien vers la page B !!!</Text>
        <Button
          title="Go to Page B"
          onPress={() => navigation.navigate('PageB')}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  view: {
    margin: 15,
  },
});
