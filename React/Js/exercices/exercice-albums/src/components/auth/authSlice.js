import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { SIGN_UP_URL, SIGN_IN_URL } from "../../fireBaseConfig";

export const signUp = createAsyncThunk("auth/signUp", async (credentials) => {
  const response = await fetch(SIGN_UP_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(credentials),
  });
  const data = await response.json();
  localStorage.setItem("token", data.idToken);
  return { id: data.name, ...credentials };
});

export const signIn = createAsyncThunk("auth/signIn", async (credentials) => {
  const response = await fetch(SIGN_IN_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(credentials),
  });
  const data = await response.json();
  localStorage.setItem("token", data.idToken);
  return { id: data.name, ...credentials };
});

const authSlice = createSlice({
  name: "auth",
  initialState: {
    user: null,
    authMode: "Sign in",
  },
  reducers: {
    removeUser: (state, action) => {
      state.user = null;
      localStorage.removeItem("token");
    },
    setAuthMode: (state, action) => {
      state.authMode = action.payload;
    },
  },
  extraReducers: (builder) => {
    builder.addCase(signUp.fulfilled, (state, action) => {
      state.user = action.payload;
    });
    builder.addCase(signIn.fulfilled, (state, action) => {
      state.user = action.payload;
    });
  },
});

export const { removeUser, setAuthMode } = authSlice.actions;
export default authSlice.reducer;
