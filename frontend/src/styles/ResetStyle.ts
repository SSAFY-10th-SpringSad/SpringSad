import { css } from '@emotion/react';

const ResetStyle = css`
  body {
    margin: 0;
    font-family: 'LINESeedKR-Bd', sans-serif;
  }
  a {
    text-decoration: none;
    color: #222;
  }

  * {
    box-sizing: border-box;
    font-size: 14px;
  }
  @font-face {
    font-family: 'LINESeedKR-Bd';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/LINESeedKR-Bd.woff2')
      format('woff2');
    font-weight: 700;
    font-style: normal;
  }
  button {
    background: inherit;
    border: none;
    box-shadow: none;
    border-radius: 0;
    padding: 0;
    overflow: visible;
    cursor: pointer;
  }
`;

export default ResetStyle;
