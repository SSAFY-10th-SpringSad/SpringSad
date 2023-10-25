import { LoginState } from '@/store/status';
import { useRecoilValue } from 'recoil';

type Props = {
  children: React.ReactNode;
};

export default function PageWithLogin({ children }: Props) {
  const isLogin = useRecoilValue(LoginState);
  if (!isLogin) {
    return <>로그인이 필요합니다.</>;
    //여기서 로그인해달라고 알린 다음 로그인페이지로 리다이렉트한다.
  }
  return (
    <>
      <>{children}</>
    </>
  );
}
