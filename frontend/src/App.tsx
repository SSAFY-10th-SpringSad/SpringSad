import { ThemeProvider } from '@emotion/react';
import { theme } from './styles/Theme';
import Header from './components/header';

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Header></Header>
      <div>Hello, Spring Sad</div>
    </ThemeProvider>
  );
}

export default App;
