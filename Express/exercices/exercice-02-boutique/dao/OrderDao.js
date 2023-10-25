import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

class OrderDao {
  constructor() {
    this.file = resolve("./data/orders.json");
    this.orders = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.orders = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.orders));
  }

  save(order) {
    order.id = Date.now();
    this.orders.push(order);
    this.writeFile();
    return customer;
  }
}

export default OrderDao;
