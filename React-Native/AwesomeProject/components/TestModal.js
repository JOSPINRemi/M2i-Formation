import { Button, Modal, Text, View } from 'react-native';

function TestModal(props) {
  return (
    <Modal visible={props.visible}>
      <View>
        <Text>Ceci est ma Modal React Native !!!</Text>
        <Button title="close Modal" onPress={props.closeModal} />
      </View>
    </Modal>
  );
}

export default TestModal;
