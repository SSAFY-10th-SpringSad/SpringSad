import { ThemeProvider } from '@emotion/react';
import theme from './styles/Theme';

import { BrowserRouter } from 'react-router-dom';
import Router from './routes/Router';
import { Global } from '@emotion/react';
import ResetStyle from './styles/ResetStyle';
import { worker } from './mock/serviceWorker';

function App() {
  if (process.env.NODE_ENV === 'development') {
    worker.start();
  }
  return (
    <ThemeProvider theme={theme}>
      <Global styles={ResetStyle} />
      <BrowserRouter>
        <Router />
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;
