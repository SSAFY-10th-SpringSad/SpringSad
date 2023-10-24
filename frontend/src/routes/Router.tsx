import { Route, Routes } from 'react-router-dom';
import BandDetailPage from '@/pages/BandDetailPage/BandDetailPage';
import CreateBandPage from '@/pages/CreateBandPage/CreateBandPage';
import HomePage from '@/pages/HomePage/HomePage';
import LoginPage from '@/pages/LoginPage/LoginPage';
import { BROWSER_PATH } from '@/constants/path';
import SignUpPage from '@/pages/SignUpPage/SignUpPage';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';

const Router = createBrowserRouter([
  {
    path: BROWSER_PATH.HOME,
    element: <HomePage />,
  },
  {
    path: BROWSER_PATH.LOGIN,
    element: <LoginPage />,
  },
  {
    path: BROWSER_PATH.SIGN_UP,
    element: <SignUpPage />,
  },
  {
    path: BROWSER_PATH.CREATE_BAND,
    element: <CreateBandPage />,
  },
  {
    path: '/band:bandId',
    element: <BandDetailPage />,
  },
]);
export default Router;
// export default function Router() {
//   return (
//     <Routes>
//       <Route path={BROWSER_PATH.HOME} element={<HomePage />} />
//       <Route path={BROWSER_PATH.LOGIN} element={<LoginPage />} />
//       <Route path={BROWSER_PATH.SIGN_UP} element={<SignUpPage />} />
//       <Route path="/band:bandId" element={<BandDetailPage />} />
//       <Route path={BROWSER_PATH.CREATE_BAND} element={<CreateBandPage />} />
//     </Routes>
//   );
// }
