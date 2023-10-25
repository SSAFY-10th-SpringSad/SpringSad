import { ThemeProvider } from '@emotion/react';
import theme from './styles/Theme';
import { RecoilRoot } from 'recoil';
import { RouterProvider } from 'react-router-dom';
import { Global } from '@emotion/react';
import ResetStyle from './styles/ResetStyle';
import { worker } from './mock/serviceWorker';
import Router from './routes/Router';

function App() {
  if (process.env.NODE_ENV === 'development') {
    worker.start();
  }
  return (
    <RecoilRoot>
      <ThemeProvider theme={theme}>
        <Global styles={ResetStyle} />
        <RouterProvider router={Router} />
      </ThemeProvider>
    </RecoilRoot>
  );
}

export default App;
