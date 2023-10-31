import styled from '@emotion/styled';
import { Link } from 'react-router-dom';
type StyledProps = {
  bgColor: string;
  fontColor: string;
};

const Container = styled(Link)`
  border: 1px solid lightgray;
  width: 300px;
  height: 60px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 18px;
  background-color: ${(props: StyledProps): string => props.bgColor};
  color: ${(props: StyledProps): string => props.fontColor};
`;

export { Container };
