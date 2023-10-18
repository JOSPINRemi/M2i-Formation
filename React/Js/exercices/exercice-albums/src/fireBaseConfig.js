// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCrxPPiNqC1nOsfbzXY-HpEr1BQB6OpsFs",
  authDomain: "cda-m2i-94675.firebaseapp.com",
  databaseURL:
    "https://cda-m2i-94675-default-rtdb.europe-west1.firebasedatabase.app",
  projectId: "cda-m2i-94675",
  storageBucket: "cda-m2i-94675.appspot.com",
  messagingSenderId: "388042762311",
  appId: "1:388042762311:web:98fa30b622677962016962",
  measurementId: "G-89B79QTGQ8",
};

export const BASE_DB_URL = firebaseConfig.databaseURL;
export const SIGN_UP_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=${firebaseConfig.apiKey}`;
export const SIGN_IN_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=${firebaseConfig.apiKey}`;

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
