import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { BASE_DB_URL } from "../../fireBaseConfig";

export const fetchAlbums = createAsyncThunk(
  "albumItems/fetchAlbums",
  async () => {
    const response = await fetch(BASE_DB_URL + "/albums.json");
    const data = await response.json();
    const albums = [];
    for (const key in data) {
      albums.push({ id: key, ...data[key] });
    }
    return albums;
  }
);

const albumItemsSlice = createSlice({
  name: "albumItems",
  initialState: {
    albums: [],
  },
  reducers: {},

  extraReducers: (builder) => {
    builder.addCase(fetchAlbums.fulfilled, (state, action) => {
      state.albums = action.payload;
      console.log(state.albums);
    });
  },
});

export default albumItemsSlice.reducer;
