import { Email, Role, UUID } from "@chia/shared/types";

export type LocalUser = {
  user: {
    id?: UUID;
    email?: Email;
    name?: string;
    role?: Role;
  };
  token?: string;
};
