import { type UUID } from "@chia/shared/types";
import { getBaseUrl } from "@chia/util/getBaseUrl";

export const getAllUsers = async (
  token: string
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/api/user/all`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const getUser = async (
  token: string,
  id: UUID
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/api/user/${id}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const postUserArmor = async (
  token: string,
  armorId: UUID
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(
    `${getBaseUrl()}/api/user/update-armor?armorId=${armorId}`,
    {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    }
  );
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const deleteUserArmor = async (
  token: string
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/api/user/remove-armor`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const postUserHeadgear = async (
  token: string,
  headgearId: UUID
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(
    `${getBaseUrl()}/api/user/update-headgear?headgearId=${headgearId}`,
    {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    }
  );
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const deleteUserHeadgear = async (
  token: string
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/api/user/remove-headgear`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const postUserWeapon = async (
  token: string,
  weaponId: UUID
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(
    `${getBaseUrl()}/api/user/update-weapon?weaponId=${weaponId}`,
    {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    }
  );
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const deleteUserWeapon = async (
  token: string
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/api/user/remove-weapon`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const postUserShield = async (
  token: string,
  shieldId: UUID
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(
    `${getBaseUrl()}/api/user/update-shield?shieldId=${shieldId}`,
    {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    }
  );
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};

export const deleteUserShield = async (
  token: string
): Promise<{
  data: any;
  status: number;
}> => {
  const res = await fetch(`${getBaseUrl()}/api/user/remove-shield`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
  });
  const data: any = await res.json();

  return {
    data,
    status: res.status,
  };
};
