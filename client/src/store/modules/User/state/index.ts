﻿import type { User } from "@chia/shared/types";

export interface IUserState {
  allUsers: {
    loading: "idle" | "pending" | "succeeded" | "failed";
    error: any;
    data?: User[] | null;
  };
  user: {
    loading: "idle" | "pending" | "succeeded" | "failed";
    error: any;
    data?: User | null;
  };
  updateLoading: "idle" | "pending" | "succeeded" | "failed";
}

export const userInitState: IUserState = {
  allUsers: {
    loading: "idle",
    error: null,
    data: null,
  },
  user: {
    loading: "idle",
    error: null,
    data: null,
  },
  updateLoading: "idle",
};
