import Geolocation from '@react-native-community/geolocation';
import React, {useEffect, useState} from 'react';
import {StyleSheet, Text, View} from 'react-native';

export default function App() {
  const ENDPOINT =
    'http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=';
  const APIKEY = 'OrQwD1YdtVmWDFX8laSnGQwAgp3ECp89';
  const [latitude, setLatitude] = useState(null);
  const [longitude, setLongitude] = useState(null);

  const [fetchedData, setFetchedData] = useState(null);

  useEffect(() => {
    Geolocation.requestAuthorization();
    Geolocation.getCurrentPosition(
      position => {
        setLatitude(position.coords.latitude);
        setLongitude(position.coords.longitude);
      },
      error => console.log(error),
      {enableHighAccuracy: true, timeout: 20000, maximumAge: 1000},
    );
  }, []);

  useEffect(() => {
    fetch(`${ENDPOINT}${APIKEY}&q=${latitude}%2C%${longitude}`)
      .then(response => {
        if (!response.ok) {
          throw new Error(
            `La requête a échouée avec un statut : ${response.status}`,
          );
        }
        return response.json();
      })
      .then(data => {
        setFetchedData(data);
      })
      .catch(error => {
        console.error('Erreur : ' + error);
      });
  }, [latitude, longitude]);

  return (
    <View>
      {fetchedData ? (
        <View>
          <Text>Lieu : {fetchedData.LocalizedName}</Text>
          <Text>Ville : {fetchedData.ParentCity.LocalizedName}</Text>
          <Text>Pays : {fetchedData.Country.LocalizedName}</Text>
          <Text>Region: {fetchedData.Region.LocalizedName}</Text>
        </View>
      ) : (
        <Text>No data</Text>
      )}
    </View>
  );
}

const styles = StyleSheet.create({});
