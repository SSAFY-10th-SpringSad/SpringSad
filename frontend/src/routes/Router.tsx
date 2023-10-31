import BandDetailPage from '@/pages/BandDetailPage/BandDetailPage';
import CreateBandPage from '@/pages/CreateBandPage/CreateBandPage';
import HomePage from '@/pages/HomePage/HomePage';
import LoginPage from '@/pages/LoginPage/LoginPage';
import { BROWSER_PATH, BROWSER_TYPE } from '@/constants/path';
import SignUpPage from '@/pages/SignUpPage/SignUpPage';
import { createBrowserRouter } from 'react-router-dom';
import { routerItem } from '@/@types/routerItem';
import PageWithLogin from './PageWithLogin';
import PageWithoutLogin from './PageWithoutLogin';
import LandingPage from '@/pages/LandingPage/LandingPage';
import LoginTypePage from '@/pages/LoginTypePage/LoginTypePage';
import SignUpTypePage from '@/pages/SignUpTypePage/SignUpTypePage';

const RouterInfo: routerItem[] = [
  {
    path: BROWSER_PATH.LANDING,
    element: <LandingPage />,
    withAuth: false,
    label: 'Landing',
  },
  {
    path: BROWSER_PATH.HOME,
    element: <HomePage />,
    withAuth: true,
    label: 'Home',
  },
  {
    path: BROWSER_TYPE.LOGIN,
    element: <LoginPage />,
    withAuth: false,
    label: 'Login',
  },
  {
    path: BROWSER_PATH.LOGIN,
    element: <LoginTypePage />,
    withAuth: false,
    label: 'LoginType',
  },
  {
    path: BROWSER_TYPE.SIGN_UP,
    element: <SignUpPage />,
    withAuth: false,
    label: 'SignUp',
  },
  {
    path: BROWSER_PATH.SIGN_UP,
    element: <SignUpTypePage />,
    withAuth: false,
    label: 'SignUpType',
  },

  {
    path: BROWSER_PATH.CREATE_BAND,
    element: <CreateBandPage />,
    withAuth: true,
    label: 'CreateBand',
  },
  {
    path: '/band:bandId',
    element: <BandDetailPage />,
    withAuth: true,
    label: 'BandDetail',
  },
];

const router = createBrowserRouter(
  RouterInfo.map((routerInfo: routerItem) => {
    return routerInfo.withAuth
      ? {
          path: routerInfo.path,
          element: <PageWithLogin>{routerInfo.element}</PageWithLogin>,
        }
      : {
          path: routerInfo.path,
          element: <PageWithoutLogin>{routerInfo.element}</PageWithoutLogin>,
        };
  }),
);

export default router;
