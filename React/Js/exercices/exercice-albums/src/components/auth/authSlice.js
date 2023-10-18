import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

export const setUser = createAsyncThunk(
  "auth/setUser",
  async ({ url, credentials }) => {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(credentials),
    });
    const data = await response.json();
    return { id: data.name, ...credentials };
  }
);

export const setAuthMode = createAsyncThunk(
  "auth/authMode",
  async (authMode) => {
    return authMode;
  }
);

const authSlice = createSlice({
  name: "auth",
  initialState: {
    user: null,
    authMode: "Sign in",
  },
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(setUser.fulfilled, (state, action) => {
      state.user = action.payload;
    });
    builder.addCase(setAuthMode.fulfilled, (state, action) => {
      state.authMode = action.payload;
    });
  },
});

export default authSlice.reducer;
