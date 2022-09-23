import { createAsyncThunk } from "@reduxjs/toolkit";
import { getAllHeadgear, getHeadgear } from "@chia/api/item";
import type { UUID } from "@chia/shared/types";

export const getAllHeadgearAsync = createAsyncThunk(
  "headgear/getAllHeadgear",
  async (token: string, { rejectWithValue }) => {
    try {
      const response = await getAllHeadgear(token);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);

export const getHeadgearAsync = createAsyncThunk(
  "headgear/getHeadgear",
  async ({ token, id }: { token: string; id: UUID }, { rejectWithValue }) => {
    try {
      const response = await getHeadgear(token, id);
      if (response.status !== 200)
        return rejectWithValue(response.data.message);
      return response;
    } catch (error) {
      return rejectWithValue(error);
    }
  }
);
