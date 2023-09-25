class Person {
    constructor(firstname, lastname, age, numeroIdNat) {
        this._id = ++Person._count;
        this._firstname = firstname;
        this._lastname = lastname;
        this._age = age;
        this.numeroIdNat = numeroIdNat;
    }
    get firstname() {
        return this._firstname;
    }
    set firstname(value) {
        if (value !== "Blabla") {
            this._firstname = value;
        }
    }
    get fullname() {
        return this._firstname + " " + this._lastname;
    }
    static get count() {
        return Person._count;
    }
}
Person._count = 0;
class Student extends Person {
    constructor(firstname, lastname, age, numeroIdNat, backpack) {
        super(firstname, lastname, age, numeroIdNat);
        this._backpack = backpack;
    }
    toString() {
        return this.fullname + ` backpack ? ${this._backpack}`;
    }
}
export { Person, Student };
