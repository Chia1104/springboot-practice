import { createAsyncThunk } from "@reduxjs/toolkit";
import { getAllWeapons, getWeapon } from "@chia/api/item";
import type { UUID } from "@chia/shared/types";

export const getAllWeaponsAsync = createAsyncThunk(
  "weapon/getAllWeapons",
  async (token: string, { rejectWithValue }) => {
    try {
      const response = await getAllWeapons(token);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);

export const getWeaponAsync = createAsyncThunk(
  "weapon/getWeapon",
  async ({ token, id }: { token: string; id: UUID }, { rejectWithValue }) => {
    try {
      const response = await getWeapon(token, id);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);
