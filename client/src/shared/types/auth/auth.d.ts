import { Email, UUID, Role } from "@chia/shared/types";

export type Auth = {
  user: {
    id?: UUID;
    email?: Email;
    name?: string;
    role?: Role;
  };
  token?: string;
};
