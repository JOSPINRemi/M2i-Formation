import {useState} from 'react';
import {Button, StyleSheet, Text, TextInput, View} from 'react-native';

function GroceryForm(props) {
  const [textInput, setTextInput] = useState('');

  function RecupInput(enteredText) {
    setTextInput(enteredText);
  }

  function submitForm() {
    props.setTab(prevState => [...prevState, textInput]);
    setTextInput('');
  }

  return (
    <View>
      <TextInput
        onChangeText={RecupInput}
        value={textInput}
        style={
          textInput.trim() === '' ? styles.inputInvalid : styles.inputValid
        }
      />
      <Button
        title="Add to list"
        onPress={submitForm}
        disabled={textInput.trim() === ''}
      />
      {textInput.trim() === '' ? (
        <Text style={styles.infoMessage}>
          Please enter something in the field
        </Text>
      ) : (
        ''
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  inputValid: {borderWidth: 1, borderColor: 'green'},
  inputInvalid: {borderWidth: 1, borderColor: 'red'},
  infoMessage: {
    color: 'red',
    textAlign: 'center',
  },
});

export default GroceryForm;
