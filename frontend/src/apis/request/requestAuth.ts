import { axios } from '../axios';
import { API_PATH } from '@/constants/path';

const requestLoginByEmail = (userData: RequestLoginByEmailType) => {
  return axios.post<ResponseLogin>(API_PATH.AUTH.LOGIN_BY_EMAIL, userData);
};

const requestLoginByPhone = (userData: RequestLoginByPhoneType) => {
  return axios.post<ResponseLogin>(API_PATH.AUTH.LOGIN_BY_PHONE, userData);
};

export { requestLoginByEmail, requestLoginByPhone };
