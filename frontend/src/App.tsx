import { ThemeProvider } from '@emotion/react';
import theme from './styles/Theme';

import { BrowserRouter } from 'react-router-dom';
import Router from './routes/Router';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter>
        <Router />
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;
