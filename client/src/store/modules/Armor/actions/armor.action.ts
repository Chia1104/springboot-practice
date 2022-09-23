import { createAsyncThunk } from "@reduxjs/toolkit";
import { getAllArmors, getArmor } from "@chia/api/item";
import type { UUID } from "@chia/shared/types";

export const getAllArmorsAsync = createAsyncThunk(
  "armor/getAllArmor",
  async (token: string, { rejectWithValue }) => {
    try {
      const response = await getAllArmors(token);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);

export const getArmorAsync = createAsyncThunk(
  "armor/getArmor",
  async ({ token, id }: { token: string; id: UUID }, { rejectWithValue }) => {
    try {
      const response = await getArmor(token, id);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);
