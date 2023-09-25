export class Person {
    constructor(firstname, lastname, dateofbirth, email, phonenumber) {
        this._id = ++Person._count;
        this._firstname = firstname;
        this._lastname = lastname;
        this._dateofbirth = dateofbirth;
        this._email = email;
        this._phonenumber = phonenumber;
    }
    get firstname() {
        return this._firstname;
    }
    set firstname(v) {
        this._firstname = v;
    }
    get lastname() {
        return this._lastname;
    }
    set lastname(v) {
        this._lastname = v;
    }
    get dateofbirth() {
        return this._dateofbirth;
    }
    set dateofbirth(v) {
        this._dateofbirth = v;
    }
    get email() {
        return this._email;
    }
    set email(v) {
        this._email = v;
    }
    get phonenumber() {
        return this._phonenumber;
    }
    set phonenumber(v) {
        this._phonenumber = v;
    }
}
Person._count = 0;
