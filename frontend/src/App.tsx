import { ThemeProvider } from '@emotion/react';
import theme from './styles/Theme';

import Header from './components/header';
import Footer from './components/footer';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter>
        <Header />
        <div>Hello, Spring Sad</div>
        <Footer />
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;
