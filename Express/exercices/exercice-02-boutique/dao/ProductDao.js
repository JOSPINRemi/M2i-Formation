import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

class ProductDao {
  constructor() {
    this.file = resolve("./data/products.json");
    this.products = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.customers = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.products));
  }

  save(product) {
    product.id = Date.now();
    this.products.push(product);
    this.writeFile();
    return product;
  }

  findById(id) {
    return this.products.find((c) => c.id == id);
  }
}

export default ProductDao;
