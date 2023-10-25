import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

class CustomerDao {
  constructor() {
    this.file = resolve("./data/customers.json");
    this.customers = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.customers = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.customers));
  }

  save(customer) {
    customer.id = Date.now();
    this.customers.push(customer);
    this.writeFile();
    return customer;
  }

  getAll() {
    return this.customers;
  }

  findById(id) {
    return this.customers.find((c) => c.id == id);
  }
}

export default CustomerDao;
