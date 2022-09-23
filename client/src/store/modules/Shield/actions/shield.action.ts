import { createAsyncThunk } from "@reduxjs/toolkit";
import { getAllShields, getShield } from "@chia/api/item";
import type { UUID } from "@chia/shared/types";

export const getAllShieldsAsync = createAsyncThunk(
  "shield/getAllShields",
  async (token: string, { rejectWithValue }) => {
    try {
      const response = await getAllShields(token);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);

export const getShieldAsync = createAsyncThunk(
  "shield/getShield",
  async ({ token, id }: { token: string; id: UUID }, { rejectWithValue }) => {
    try {
      const response = await getShield(token, id);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);
