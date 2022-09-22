import type { Email, Password } from "@chia/shared/types";
import type { RegisterDto } from "@chia/shared/interface/register.dto";
import { getBaseUrl } from "@chia/util/getBaseUrl";

export const login = async (
  email: Email,
  password: Password
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/auth/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, password }),
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const register = async (
  register: RegisterDto
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/auth/register`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(register),
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};
