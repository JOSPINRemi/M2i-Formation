const Cart = () => {
  const showCart = () => {
    if (localStorage.getItem("cart")) {
      let userCart = JSON.parse(localStorage.getItem("cart"));
      let sum = 0;
      return (
        <>
          <ul style={{ listStyle: "none" }}>
            {userCart.map((cartProduct, id) => {
              {
                sum += cartProduct.price;
              }
              return (
                <li key={id}>
                  {cartProduct.name}{" "}
                  {cartProduct.price.toLocaleString("fr-FR", {
                    style: "currency",
                    currency: "EUR",
                  })}
                </li>
              );
            })}
          </ul>
          <p>
            Total :{" "}
            {sum.toLocaleString("fr-FR", {
              style: "currency",
              currency: "EUR",
            })}
          </p>
        </>
      );
    } else {
      return <p>Cart is empty</p>;
    }
  };

  return (
    <main>
      <h2>Cart</h2>
      {showCart()}
    </main>
  );
};

export default Cart;
