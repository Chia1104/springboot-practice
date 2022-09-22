export const IS_PRODUCTION = import.meta.env.NODE_ENV === "production";

// Site url
export const BASE_URL =
  process.env.NODE_ENV === "production"
    ? "https://chia1104.dev"
    : import.meta.env.VITE_BASE_URL || "http://localhost:8080";
export const RAILWAY_URL = import.meta.env.RAILWAY_STATIC_URL;
export const VERCEL_URL = import.meta.env.VERCEL_URL;
