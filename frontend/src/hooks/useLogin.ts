import { requestLogin } from '@/apis/request/requestAuth';
import useInput from './useInput';
import { useNavigate } from 'react-router-dom';
import { BROWSER_PATH } from '@/constants/path';

function useLogin(type: string) {
  const { value: email, onChange: onChangeEmail } = useInput('');
  const { value: password, onChange: onChangePassword } = useInput('');
  const { value: phone, onChange: onChangePhone } = useInput('');
  const navigate = useNavigate();
  const login = () => {
    requestLogin(
      type === 'email' ? { email, password } : { phone, password },
      type,
    )
      .then(res => {
        sessionStorage.setItem('userId', JSON.stringify(res.data.userId));
        navigate(BROWSER_PATH.HOME);
      })
      .catch(err => {
        console.log(err);
      });
  };

  return {
    onChangeEmail,
    onChangePhone,
    onChangePassword,
    login,
  };
}
export default useLogin;
