import React from 'react';
import styled from '@emotion/styled';
type Props = {};

const HeaderWrapper = styled.header`
  width: 100vw;
  height: 50px;
  background-color: white;
  border-bottom: 1px solid #f2f2f2;
`;
const HeaderContents = styled.div`
  width: 1100px;
  height: 50px;
  border: 1px solid black;
  margin: 0 auto;
`;
const LogoSearchArea = styled.div``;
const WidgetArea = styled.div``;
export default function Header({}: Props) {
  return (
    <HeaderWrapper>
      <HeaderContents></HeaderContents>
    </HeaderWrapper>
  );
}
