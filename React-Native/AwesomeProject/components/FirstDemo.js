import {useState} from 'react';
import {
  Button,
  FlatList,
  StyleSheet,
  Text,
  TextInput,
  View,
} from 'react-native';
import TestModal from './TestModal';

function FirstDemo() {
  const [textInput, setTextInput] = useState('');
  const [modalVisible, setModalVisible] = useState(false);

  function RecupInput(enterText) {
    setTextInput(enterText);
    console.log(textInput);
  }

  function MessageConsole() {
    console.log('Clique sur le bouton');
    setModalVisible(true);
  }

  function closeModal() {
    console.log('Ferme la Modal');
    setModalVisible(false);
  }

  const tab = [
    {text: 'toto', id: 1},
    {text: 'tata', id: 2},
    {text: 'tutu', id: 3},
  ];

  return (
    <View style={styles.container}>
      <Text style={[styles.monTexte, styles.taileTexte]}>
        Mon premier composant React Native
      </Text>
      <TextInput onChangeText={RecupInput} value={textInput} />
      <Button title="Bouton" onPress={MessageConsole} />
      <TestModal visible={modalVisible} closeModal={closeModal} />
      <FlatList
        data={tab}
        renderItem={itemData => {
          return (
            <View>
              <Text style={styles.monTexte}>{itemData.item.text}</Text>
            </View>
          );
        }}
        keyExtractor={(item, index) => {
          return index;
        }}
      />
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
