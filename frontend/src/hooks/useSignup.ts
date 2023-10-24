import { requestSignUp } from '@/apis/request/requestUser';
import { BROWSER_PATH } from '@/constants/path';
import { ChangeEvent, useState } from 'react';
import { useNavigate } from 'react-router-dom';

function useSignup(type: string) {
  const navigate = useNavigate();
  const [userData, setUserData] = useState<RequestSignUpByEmailType>({
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

  const signup = () => {
    requestSignUp(userData, type)
      .then(() => {
        navigate(BROWSER_PATH.HOME);
      })
      .catch(err => {
        alert('일단은 틀렸음');
      });
  };

  return {
    onChnageUserData,
    signup,
  };
}

export default useSignup;
