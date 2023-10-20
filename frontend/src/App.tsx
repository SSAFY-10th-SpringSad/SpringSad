import { ThemeProvider } from '@emotion/react';
import theme from './styles/Theme';

import { BrowserRouter } from 'react-router-dom';
import Router from './routes/Router';
import { Global } from '@emotion/react';
import ResetStyle from './styles/ResetStyle';
function App() {
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
