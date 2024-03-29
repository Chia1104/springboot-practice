﻿import type { Armor } from "@chia/shared/types";

export interface IArmorState {
  allArmors: {
    loading: "idle" | "pending" | "succeeded" | "failed";
    error: any;
    data: Armor[] | null;
  };
  armor: {
    loading: "idle" | "pending" | "succeeded" | "failed";
    error: any;
    data: Armor | null;
  };
}

export const armorInitState: IArmorState = {
  allArmors: {
    loading: "idle",
    error: null,
    data: null,
  },
  armor: {
    loading: "idle",
    error: null,
    data: null,
  },
};
