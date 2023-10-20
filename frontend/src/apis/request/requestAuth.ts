import { axios } from '../axios';
import { API_PATH } from '@/constants/path';

const requestLogin = (userData: LoginUserType) => {
  return axios.post(API_PATH.AUTH.LOGIN, userData);
};

export { requestLogin };
