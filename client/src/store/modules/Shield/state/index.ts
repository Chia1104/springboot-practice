import type { Shield } from "@chia/shared/types";

export interface IShieldState {
  allShields: {
    loading: "idle" | "pending" | "succeeded" | "failed";
    error: any;
    data: Shield[] | null;
  };
  shield: {
    loading: "idle" | "pending" | "succeeded" | "failed";
    error: any;
    data: Shield | null;
  };
}

export const shieldInitState: IShieldState = {
  allShields: {
    loading: "idle",
    error: null,
    data: null,
  },
  shield: {
    loading: "idle",
    error: null,
    data: null,
  },
};
