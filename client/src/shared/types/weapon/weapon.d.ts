import { UUID } from "@chia/shared/types";

export type Weapon = {
  id: UUID;
  name: string;
  description: string;
  image: string;
  defense: number;
  attack: number;
  level: number;
  category: number;
  heaviness: number;
};
