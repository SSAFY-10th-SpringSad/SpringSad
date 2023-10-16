import styled from '@emotion/styled';
import Router from './route/Router';

import color from './styles/colorVar';

const GlobalStyle = styled.div``;
function App() {
  return (
    <GlobalStyle>
      <Router />
    </GlobalStyle>
  );
}

export default App;
