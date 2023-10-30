import { requestLogin } from '@/apis/request/requestAuth';
import useInput from './useInput';
import { useNavigate } from 'react-router-dom';
import { BROWSER_PATH } from '@/constants/path';
import { useSetRecoilState } from 'recoil';
import { LoginState } from '@/store/status';

function useLogin(type: string) {
  const { value: email, onChange: onChangeEmail } = useInput('');
  const { value: password, onChange: onChangePassword } = useInput('');
  const { value: phone, onChange: onChangePhone } = useInput('');
  const navigate = useNavigate();
  const setLoginState = useSetRecoilState(LoginState);
  const login = () => {
    requestLogin(
      type === 'email' ? { email, password } : { phone, password },
      type,
    )
      .then(res => {
        setLoginState(true);
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
