import { requestLogin } from '@/apis/request/requestAuth';
import useInput from './useInput';

function useLogin() {
  const { value: email, onChange: onChangeEmail } = useInput('');
  const { value: password, onChange: onChangePassword } = useInput('');
  const login = () => {
    requestLogin({ email, password })
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
    login,
  };
}
export default useLogin;
