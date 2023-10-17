import { ThemeProvider } from '@emotion/react';
import theme from './styles/Theme';

import Header from './components/header/Header';
import Footer from './components/footer';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Header />
      <div>Hello, Spring Sad</div>
      <Footer />
    </ThemeProvider>
  );
}

export default App;
