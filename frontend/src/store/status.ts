import { atom } from 'recoil';

const LoginState = atom({
  key: 'LoginState',
  default: false,
});

export { LoginState };
