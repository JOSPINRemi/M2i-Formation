import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

class ContactDao {
  constructor() {
    this.file = resolve("./data/db.json");
    this.contacts = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.contacts = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.contacts));
  }

  save(contact) {
    contact.id = Date.now();
    this.contacts.push(contact);
    this.writeFile();
    return contact;
  }

  getAll() {
    return this.contacts;
  }

  findById(id) {
    return this.contacts.find((c) => c.id == id);
  }

  update(contactUpdate) {
    const contact = this.findById(contactUpdate.id);
    if (contact === undefined) {
      return false;
    }
    for (const key in contact) {
      contact[key] = contactUpdate[key];
    }

    this.writeFile();
    return true;
  }

  delete(id) {
    this.contacts = this.contacts.filter((c) => c.id != id);
    this.writeFile();
  }
}

export default ContactDao;
