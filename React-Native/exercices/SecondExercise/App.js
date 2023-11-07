import React, {useState} from 'react';
import {Button, FlatList, Pressable, StyleSheet, View} from 'react-native';
import Article from './components/Article';
import ModalInput from './components/ModalInput';

export default function App() {
  const [modalIsVisible, setModalIsVisible] = useState(false);
  const [articles, setArticles] = useState([]);

  function addArticle(article) {
    setArticles(articlesCurrent => [
      ...articlesCurrent,
      {text: article, id: Math.random().toString()},
    ]);
    setModalIsVisible(false); //  closeModale()
  }

  function closeModale() {
    setModalIsVisible(false);
  }

  function openModale() {
    setModalIsVisible(true);
  }

  function removeArticle(id) {
    setArticles(articlesCurrent =>
      articlesCurrent.filter(article => article.id !== id),
    );
  }

  return (
    <View style={styles.container}>
      <Button title="Add Article" onPress={openModale} />
      <ModalInput
        visible={modalIsVisible}
        closeModale={closeModale}
        addArticle={addArticle}></ModalInput>
      <FlatList
        data={articles}
        renderItem={itemData => {
          return (
            <Pressable onPress={() => removeArticle(itemData.item.id)}>
              <Article item={itemData.item}></Article>
            </Pressable>
          );
        }}
        keyExtractor={(item, index) => {
          return index; // item.id
        }}></FlatList>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 20,
    paddingHorizontal: 16,
  },
});
