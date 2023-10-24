import { axios } from '../axios';
import { API_PATH } from '@/constants/path';

const requestLogin = (
  userData: RequestLoginByEmailType | RequestLoginByPhoneType,
  type: string,
) => {
  return axios.post<ResponseLogin>(
    type === 'email'
      ? API_PATH.AUTH.LOGIN_BY_EMAIL
      : API_PATH.AUTH.LOGIN_BY_PHONE,
    userData,
  );
};

export { requestLogin };
