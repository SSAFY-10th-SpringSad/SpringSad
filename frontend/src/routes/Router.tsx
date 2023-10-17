import { Route, Routes } from 'react-router-dom';
import BandDetailPage from '@/pages/BandDetailPage/BandDetailPage';
import CreateBandPage from '@/pages/CreateBandPage/CreateBandPage';
import HomePage from '@/pages/HomePage/HomePage';
import LoginPage from '@/pages/LoginPage/LoginPage';
import SignUpPage from '@/pages/SignUpPage/SignUpPage';

export default function Router() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/signup" element={<SignUpPage />} />
      <Route path="/band:bandId" element={<BandDetailPage />} />
      <Route path="/createBand" element={<CreateBandPage />} />
    </Routes>
  );
}
