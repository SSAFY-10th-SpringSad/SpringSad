const BROWSER_PATH = {
  SIGN_UP: '/signup/:type',
  SIGN_UP_BY_EMAIL: '/signup/email',
  SIGN_UP_BY_PHONE: '/signup/email',
  HOME: '/',
  LOGIN: '/login/:type',
  CREATE_BAND: '/create_band',
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

export { BROWSER_PATH, API_PATH };
