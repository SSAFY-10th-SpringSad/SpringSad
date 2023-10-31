const BROWSER_PATH = {
  SIGN_UP_BY_EMAIL: '/signup/email',
  SIGN_UP_BY_PHONE: '/signup/phone',
  SIGN_UP: '/signup',
  HOME: '/home',
  LOGIN: '/login',

  LOGIN_BY_EMAIL: '/login/email',
  LOGIN_BY_PHONE: '/login/phone',
  CREATE_BAND: '/create_band',
  LANDING: '/',
};
const BROWSER_TYPE = {
  SIGN_UP: '/signup/:type',
  LOGIN: '/login/:type',
};

const API_PATH = {
  AUTH: {
    LOGIN_BY_EMAIL: '/login/email',
    LOGIN_BY_PHONE: '/login/phone',
  },
  USER: {
    SIGN_UP_BY_EMAIL: '/signup/email',
    SIGN_UP_BY_PHONE: '/signup/phone',
  },
};

export { BROWSER_PATH, API_PATH, BROWSER_TYPE };
