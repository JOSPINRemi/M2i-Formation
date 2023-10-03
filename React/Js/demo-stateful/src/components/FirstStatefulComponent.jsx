// const FirstStatefulComponent = () => {
//   return <></>;
// };

import { Component, PureComponent } from "react";

class FirstStatefulComponent extends PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      monPrenom: "Antoine",
    };
  }

  shouldComponentUpdate(prevProps, nextProps) {
    if (prevProps === nextProps) {
      return true;
    }

    return false;
  }

  componentDidUpdate(){
    
  }

  componentDidMount() {
    console.log("--- COMPONENT DID MOUNT ---");
  }

  componentWillUnmount() {
    console.log("--- COMPONENT WILL UNMOUNT ---");
  }

  render() {
    return (
      <>
        <h1>FirstStatefulComponent</h1>
        <hr />
        <p>Mon prénom est {this.state.monPrenom}</p>
        <button onClick={() => this.setState({ monPrenom: "Titi" })}>
          Change firstname
        </button>
      </>
    );
  }
}

export default FirstStatefulComponent;
