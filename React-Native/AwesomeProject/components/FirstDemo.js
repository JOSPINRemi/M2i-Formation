import {useState} from 'react';
import {StyleSheet, Text, TextInput, View} from 'react-native';

function FirstDemo() {
  const [textInput, setTextInput] = useState('');

  function RecupInput(enterText) {
    setTextInput(enterText);
    console.log(textInput);
  }

  return (
    <View style={styles.container}>
      <Text style={[styles.monTexte, styles.taileTexte]}>
        Mon premier composant React Native
      </Text>
      <TextInput onChangeText={RecupInput} value={textInput} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'red',
    flex: 1,
    padding: 20,
  },
  monTexte: {
    margin: 8,
    color: 'white',
  },
  taileTexte: {
    fontSize: 32,
  },
});

export default FirstDemo;
