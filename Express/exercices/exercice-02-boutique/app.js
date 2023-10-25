import express from "express";
import customers from "./routes/customers.js";
import products from "./routes/products.js";
import orders from "./routes/orders.js";
import CustomerDao from "./dao/CustomerDao.js";
import ProductDao from "./dao/ProductDao.js";
import OrderDao from "./dao/OrderDao.js";

const port = 3000;
const app = express();

export const customerDao = new CustomerDao();
export const productDao = new ProductDao();
export const orderDao = new OrderDao();

app.use(express.json());
app.use("/customers", customers);
app.use("/products", products);
app.use("/order", orders);

app.listen(port, () => {
  customerDao.readFile();
  productDao.readFile();
  orderDao.readFile();
  console.log(`http://127.0.0.1:${port}`);
});
