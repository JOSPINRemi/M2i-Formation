import { Student } from "./classes/Student.js";

// const btnAddStudent = document.querySelector("#btnAddStudent");
// btnAddStudent.addEventListener("click");

let student = new Student("Einstein", "Albert");
console.table(student);
student.addMatiere("français");
console.log(student.getNotes);
student.addNote("maths", 2);
student.addNote("français", 2);
console.log(student.getNotes);