import { axios } from '../axios';
import { API_PATH } from '@/constants/path';

const requestSignUp = (
  userData: RequestSignUpByEmailType | RequestSignUpByPhoneType,
  type: string,
) => {
  return axios.post(
    type === 'email'
      ? API_PATH.USER.SIGN_UP_BY_EMAIL
      : API_PATH.USER.SIGN_UP_BY_PHONE,
    userData,
  );
};

export { requestSignUp };
