import { requestLogin } from '@/apis/request/requestAuth';
import useInput from './useInput';

function useLogin() {
  const { value: email, onChange: onChangeEmail } = useInput('');
  const { value: password, onChange: onChangePassword } = useInput('');
  const login = () => {
    requestLogin({ email, password })
      .then(() => {
        alert('로그인성공');
      })
      .catch(err => {
        console.log(err);
      });
  };

  return {
    email,
    onChangeEmail,
    password,
    onChangePassword,
    login,
  };
}
export default useLogin;
