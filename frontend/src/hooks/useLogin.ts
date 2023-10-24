import {
  requestLoginByEmail,
  requestLoginByPhone,
} from '@/apis/request/requestAuth';
import useInput from './useInput';

function useLogin() {
  const { value: email, onChange: onChangeEmail } = useInput('');
  const { value: password, onChange: onChangePassword } = useInput('');
  const { value: phone, onChange: onChangePhone } = useInput('');

  const loginByEmail = (e: { preventDefault: () => void }) => {
    e.preventDefault();

    requestLoginByEmail({ email, password })
      .then(res => {
        sessionStorage.setItem('userId', JSON.stringify(res.data.userId));
      })
      .catch(err => {
        console.log(err);
      });
  };

  const loginByPhone = () => {
    requestLoginByPhone({ phone, password })
      .then(res => {
        sessionStorage.setItem('userId', JSON.stringify(res.data.userId));
      })
      .catch(err => {
        console.log(err);
      });
  };

  return {
    onChangeEmail,
    onChangePassword,
    onChangePhone,
    loginByEmail,
    loginByPhone,
  };
}
export default useLogin;
