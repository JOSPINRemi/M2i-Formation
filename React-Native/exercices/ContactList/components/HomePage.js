import {FlatList, Pressable, StyleSheet, Text, View} from 'react-native';
import React from 'react';

export default function HomePage({navigation}) {
  const contacts = [
    {
      lastname: 'Doe',
      firstname: 'John',
      phonenumber: '0123456789',
      email: 'john.doe@email.com',
    },
    {
      lastname: 'Smith',
      firstname: 'Matt',
      phonenumber: '0123456789',
      email: 'matt.smith@email.com',
    },
  ];

  return (
    <View>
      <FlatList
        data={contacts}
        renderItem={itemData => {
          return (
            <Pressable
              onPress={() =>
                navigation.navigate('Details', {details: itemData.item})
              }
              style={styles.contactItem}>
              <Text>
                {itemData.item.lastname} {itemData.item.firstname}
              </Text>
            </Pressable>
          );
        }}
        keyExtractor={(item, index) => {
          return index;
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({contactItem: {margin: 3}});
