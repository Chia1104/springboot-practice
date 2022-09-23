import { type UUID } from "@chia/shared/types";
import { getBaseUrl } from "@chia/util/getBaseUrl";

export const getAllArmors = async (token: string) => {
  const res = await fetch(`${getBaseUrl()}/api/armor/all`, {
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

export const getArmor = async (token: string, id: UUID) => {
  const res = await fetch(`${getBaseUrl()}/api/armor/${id}`, {
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

export const getAllHeadgear = async (token: string) => {
  const res = await fetch(`${getBaseUrl()}/api/headgear/all`, {
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

export const getHeadgear = async (token: string, id: UUID) => {
  const res = await fetch(`${getBaseUrl()}/api/headgear/${id}`, {
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

export const getAllWeapons = async (token: string) => {
  const res = await fetch(`${getBaseUrl()}/api/weapon/all`, {
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

export const getWeapon = async (token: string, id: UUID) => {
  const res = await fetch(`${getBaseUrl()}/api/weapon/${id}`, {
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

export const getAllShields = async (token: string) => {
  const res = await fetch(`${getBaseUrl()}/api/shield/all`, {
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

export const getShield = async (token: string, id: UUID) => {
  const res = await fetch(`${getBaseUrl()}/api/shield/${id}`, {
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
