import {
  Email,
  UUID,
  Armor,
  Headgear,
  Shield,
  Weapon,
  Name,
  Role,
} from "@chia/shared/types";

export type User = {
  id: UUID;
  name: Name;
  email: Email;
  role: Role;
  armor: Armor | null;
  headgear: Headgear | null;
  shield: Shield | null;
  weapon: Weapon | null;
};
