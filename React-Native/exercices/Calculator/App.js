import {StyleSheet, Text, View} from 'react-native';
import React, {useState} from 'react';
import MyButton from './components/MyButton';

export default function App() {
  const [result, setResult] = useState('0');
  const [firstValue, setFirstValue] = useState(0);
  const [operator, setOperator] = useState('');
  const [secondValue, setSecondValue] = useState(0);

  function calculate(value) {
    if (value != '+') {
      if (operator == '') {
        if (firstValue === 0) {
          setFirstValue(value);
          setResult(firstValue);
        } else {
          setFirstValue(firstValue + value);
          setResult(firstValue);
        }
      } else {
        if (secondValue === 0) {
          setSecondValue(value);
          setResult(secondValue);
        } else {
          setSecondValue(secondValue + value);
          setResult(secondValue);
        }
      }
    }
    if (value === '=') {
      setResult(parseInt(firstValue) + parseInt(secondValue));
    } else {
      setOperator(value);
      setResult(result + operator);
    }
  }

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Calculator</Text>
      <Text style={styles.result}>{result}</Text>
      <View style={styles.keyboard}>
        <MyButton value={'AC'} isRounded onPress={value => calculate(value)} />
        <MyButton value={'^'} isRounded onPress={value => calculate(value)} />
        <MyButton value={'%'} isRounded onPress={value => calculate(value)} />
        <MyButton value={'/'} isRounded onPress={value => calculate(value)} />

        <MyButton value={'7'} isRound onPress={value => calculate(value)} />
        <MyButton value={'8'} isRound onPress={value => calculate(value)} />
        <MyButton value={'9'} isRound onPress={value => calculate(value)} />
        <MyButton value={'X'} isRounded onPress={value => calculate(value)} />

        <MyButton value={'4'} isRound onPress={value => calculate(value)} />
        <MyButton value={'5'} isRound onPress={value => calculate(value)} />
        <MyButton value={'6'} isRound onPress={value => calculate(value)} />
        <MyButton value={'-'} isRounded onPress={value => calculate(value)} />

        <MyButton value={'1'} isRound onPress={value => calculate(value)} />
        <MyButton value={'2'} isRound onPress={value => calculate(value)} />
        <MyButton value={'3'} isRound onPress={value => calculate(value)} />
        <MyButton value={'+'} isRounded onPress={value => calculate(value)} />

        <MyButton value={'.'} isRound onPress={value => calculate(value)} />
        <MyButton value={'0'} isRound onPress={value => calculate(value)} />
        <MyButton value={'Del'} isRound onPress={value => calculate(value)} />
        <MyButton value={'='} isRounded onPress={value => calculate(value)} />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'black',
  },
  title: {
    color: 'white',
    fontSize: 30,
    fontWeight: 'bold',
  },
  result: {
    color: 'grey',
    fontSize: 100,
    alignSelf: 'flex-end',
    marginEnd: 30,
  },
  keyboard: {
    flexDirection: 'row',
    flexWrap: 'wrap',
  },
});
