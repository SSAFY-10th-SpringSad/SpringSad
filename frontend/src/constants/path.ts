const BROWSER_PATH = {
  HOME: '/home',
  SIGN_UP_TYPE: '/signup_type',
  LOGIN_TYPE: '/login_type',
  LOGIN: '/login_type/:type',
  SIGNUP: '/signup_type/:type',
  CREATE_BAND: '/create_band',
  LANDING: '/',
};
const BROWSER_TYPE = {
  EMAIL: 'email',
  PHONE: 'phone',
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
