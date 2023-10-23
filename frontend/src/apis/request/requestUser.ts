import { axios } from '../axios';
import { API_PATH } from '@/constants/path';

const requestSignUp = (
  userData: RequestEmailSignupUserType | RequestPhoneSignupUserType,
) => {
  return axios.post(API_PATH.USER.SIGN_UP, userData);
};

export { requestSignUp };
