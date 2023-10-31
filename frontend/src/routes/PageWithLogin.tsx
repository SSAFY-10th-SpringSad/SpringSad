import { BROWSER_PATH } from '@/constants/path';
import LandingPage from '@/pages/LandingPage/LandingPage';
import { LoginState } from '@/store/status';
import { Navigate } from 'react-router-dom';
import { useRecoilValue } from 'recoil';

type Props = {
  children: React.ReactNode;
};

export default function PageWithLogin({ children }: Props) {
  const isLogin = useRecoilValue(LoginState);
  return <>{isLogin ? children : <Navigate to={BROWSER_PATH.LANDING} />}</>;
}
