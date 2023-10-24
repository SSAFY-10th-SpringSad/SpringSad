import { requestLogin } from '@/apis/request/requestAuth';
import useInput from './useInput';

function useLogin(type: string) {
  const { value: email, onChange: onChangeEmail } = useInput('');
  const { value: password, onChange: onChangePassword } = useInput('');
  const { value: phone, onChange: onChangePhone } = useInput('');

  const login = (e: { preventDefault: () => void }) => {
    e.preventDefault();
    let success = false;
    requestLogin(
      type === 'email' ? { email, password } : { phone, password },
      type,
    )
      .then(res => {
        sessionStorage.setItem('userId', JSON.stringify(res.data.userId));
        success = true;
      })
      .catch(err => {
        console.log(err);
      });
    return success;
  };

  return {
    onChangeEmail,
    onChangePhone,
    onChangePassword,
    login,
  };
}
export default useLogin;
