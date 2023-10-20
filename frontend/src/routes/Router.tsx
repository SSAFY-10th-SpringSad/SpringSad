import { Route, Routes } from 'react-router-dom';
import BandDetailPage from '@/pages/BandDetailPage/BandDetailPage';
import CreateBandPage from '@/pages/CreateBandPage/CreateBandPage';
import HomePage from '@/pages/HomePage/HomePage';
import LoginPage from '@/pages/LoginPage/LoginPage';
import { BROWSER_PATH } from '@/constants/path';
import PhoneSignUpPage from '@/pages/SignUpPage/PhoneSignUpPage/PhoneSignUpPage';
import EmailSignUpPage from '@/pages/SignUpPage/EmailSignUpPage/EmailSignUpPage';

export default function Router() {
  return (
    <Routes>
      <Route path={BROWSER_PATH.HOME} element={<HomePage />} />
      <Route path={BROWSER_PATH.PHONE_LOGIN} element={<LoginPage />} />
      <Route path={BROWSER_PATH.PHONE_SIGN_UP} element={<PhoneSignUpPage />} />
      <Route path={BROWSER_PATH.EMAIL_SIGN_UP} element={<EmailSignUpPage />} />
      <Route path="/band:bandId" element={<BandDetailPage />} />
      <Route path={BROWSER_PATH.CREATE_BAND} element={<CreateBandPage />} />
    </Routes>
  );
}
