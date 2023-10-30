import { LoginState } from '@/store/status';
import { useRecoilValue } from 'recoil';

type Props = {
  children: React.ReactNode;
};

export default function PageWithLogin({ children }: Props) {
  return (
    <>
      <>{children}</>
    </>
  );
}
