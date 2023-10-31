import { BROWSER_PATH } from '@/constants/path';
import HomePage from '@/pages/HomePage/HomePage';
import { LoginState } from '@/store/status';
import { Navigate, useNavigate } from 'react-router-dom';
import { useRecoilValue } from 'recoil';

type Props = {
  children: React.ReactNode;
};

export default function PageWithoutLogin({ children }: Props) {
  const isLogin = useRecoilValue(LoginState);
  return <>{!isLogin ? children : <Navigate to={BROWSER_PATH.HOME} />}</>;
}
