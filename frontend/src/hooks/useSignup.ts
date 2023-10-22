import { requestLogin } from '@/apis/request/requestAuth';
import useInput from './useInput';
import { requestSignUp } from '@/apis/request/requestUser';
import { ChangeEvent, useState } from 'react';

function useSignup() {
  const [userData, setUserData] = useState<RequestSignupUserType>({
    email: '',
    password: '',
    name: '',
    birth: {
      year: 0,
      month: 0,
      day: 0,
    },
  });

  const onChnageUserData = (
    e: ChangeEvent<HTMLInputElement | HTMLSelectElement>,
  ) => {
    const { name, value } = e.target;
    if (name.startsWith('birth.')) {
      const fieldName = name.split('.')[1];
      setUserData(prevData => ({
        ...prevData,
        birth: {
          ...prevData.birth,
          [fieldName]: value,
        },
      }));
    } else {
      setUserData({
        ...userData,
        [name]: value,
      });
    }
  };

  const login = () => {
    requestSignUp(userData)
      .then(() => {
        alert('로그인성공');
      })
      .catch(err => {
        console.log(err);
      });
  };

  return {
    userData,
    onChnageUserData,
    login,
  };
}
export default useSignup;
