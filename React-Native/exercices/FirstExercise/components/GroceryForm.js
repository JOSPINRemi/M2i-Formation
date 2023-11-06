import {useState} from 'react';
import {Button, TextInput, View} from 'react-native';

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
      <TextInput onChangeText={RecupInput} value={textInput} />
      <Button title="Add to list" onPress={submitForm} />
    </View>
  );
}

export default GroceryForm;
