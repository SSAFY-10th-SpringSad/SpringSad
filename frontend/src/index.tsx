import ReactDOM from 'react-dom/client';

import App from './App';
import { ThemeProvider } from '@emotion/react';
import { theme } from './styles/Theme';

const root = ReactDOM.createRoot(document.getElementById('root')!);

root.render(<App />);
