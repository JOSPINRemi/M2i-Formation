import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { BASE_DB_URL } from "../../fireBaseConfig";

export const fetchAlbums = createAsyncThunk(
  "albumItems/fetchAlbums",
  async () => {
    const token = localStorage.getItem("token");
    const response = await fetch(`${BASE_DB_URL}/albums.json?auth=${token}`);
    const data = await response.json();
    const albums = [];
    for (const key in data) {
      albums.push({ id: key, ...data[key] });
    }
    return albums;
  }
);

export const postAlbum = createAsyncThunk(
  "albumItems/postAlbum",
  async (newAlbum) => {
    const token = localStorage.getItem("token");
    const response = await fetch(`${BASE_DB_URL}/albums.json?auth=${token}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newAlbum),
    });
    const data = await response.json();
    album = {
      id: data.name,
      ...newAlbum,
    };
    // console.log(album);
    return album;
  }
);

export const deleteAlbum = createAsyncThunk(
  "albumItems/deleteAlbum",
  async (selectedAlbum) => {
    const token = localStorage.getItem("token");
    const response = await fetch(
      `${BASE_DB_URL}/albums/${selectedAlbum}.json?auth=${token}`,
      {
        method: "DELETE",
      }
    );
    const data = await response.json();
  }
);

const albumItemsSlice = createSlice({
  name: "albumItems",
  initialState: {
    formMode: "",
    albums: [],
    selectedAlbum: null,
  },
  reducers: {
    setFormMode: (state, action) => {
      state.formMode = action.payload;
    },
    setSelectedAlbum: (state, action) => {
      state.selectedAlbum = action.payload;
    },
  },

  extraReducers: (builder) => {
    builder.addCase(fetchAlbums.fulfilled, (state, action) => {
      state.albums = action.payload;
      // console.log(state.albums);
    });
    builder.addCase(postAlbum.fulfilled, (state, action) => {
      state.albums.push(action.payload);
    });
  },
});

export const { setFormMode } = albumItemsSlice.actions;
export default albumItemsSlice.reducer;
