class Contact {
  static count = 0;

  constructor(lastname, firstname, email, phonenumber) {
    this._id = ++Contact.count;
    this._lastname = lastname;
    this._firstname = firstname;
    this._email = email;
    this._phonenumber = phonenumber;
  }
}

export default Contact;
