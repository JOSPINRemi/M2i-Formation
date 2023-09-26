export class Person {
  private static _count: number = 0;
  private _id: number;
  private _firstname: string;
  private _lastname: string;
  private _dateofbirth: Date;
  private _email: string;
  private _phonenumber: string;

  constructor(
    firstname: string,
    lastname: string,
    dateofbirth: Date,
    email: string,
    phonenumber: string
  ) {
    this._id = ++Person._count;
    this._firstname = firstname;
    this._lastname = lastname;
    this._dateofbirth = dateofbirth;
    this._email = email;
    this._phonenumber = phonenumber;
  }

  get id(): number {
    return this._id;
  }

  get firstname(): string {
    return this._firstname;
  }

  set firstname(v: string) {
    this._firstname = v;
  }

  get lastname(): string {
    return this._lastname;
  }

  set lastname(v: string) {
    this._lastname = v;
  }

  get dateofbirth(): Date {
    return this._dateofbirth;
  }

  set dateofbirth(v: Date) {
    this._dateofbirth = v;
  }

  get email(): string {
    return this._email;
  }

  set email(v: string) {
    this._email = v;
  }

  get phonenumber(): string {
    return this._phonenumber;
  }

  set phonenumber(v: string) {
    this._phonenumber = v;
  }
}
