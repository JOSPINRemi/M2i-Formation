import {StyleSheet, Text, View} from 'react-native';
import React from 'react';

export default function DetailsPage({route}) {
  const details = route.params.details;

  return (
    <View>
      <Text style={styles.contactItemData}>{details.lastname}</Text>
      <Text style={styles.contactItemData}>{details.firstname}</Text>
      <Text style={styles.contactItemData}>{details.phonenumber}</Text>
      <Text style={styles.contactItemData}>{details.email}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  contactItemData: {
    margin: 5,
  },
});
