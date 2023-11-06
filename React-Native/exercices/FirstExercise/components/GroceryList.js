import {FlatList, StyleSheet, Text, View} from 'react-native';

function Grocery(props) {
  return (
    <View>
      {console.log(props.tab)}
      <FlatList
        data={props.tab}
        renderItem={itemData => {
          return (
            <View>
              <Text style={styles.item}>{itemData.item}</Text>
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
  item: {
    textAlign: 'center',
    color: 'white',
    backgroundColor: '#1e1e1e',
  },
});

export default Grocery;
