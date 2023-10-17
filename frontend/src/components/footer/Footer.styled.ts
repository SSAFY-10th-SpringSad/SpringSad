import styled from '@emotion/styled';

const Container = styled.div`
  position: relative;
  max-width: 1034px;
  min-height: 45px;
  margin: 0 auto;
  padding: 14px 0 16px;
  font-size: 12px;
`;

const InformationsWrapper = styled.div`
  position: relative;
  display: -webkit-box;
  display: flex;
  flex-wrap: wrap;
  height: 100%;
  max-width: 900px;
  -webkit-box-align: center;
  align-items: center;
  float: left;
  line-height: 1;
`;

const Information = styled.a`
  display: -webkit-box;
  display: flex;
  -webkit-box-flex: 0;
  flex: 0 0 auto;
  -webkit-box-align: center;
  align-items: center;
  min-height: 20px;
  vertical-align: middle;
  font-style: normal;
  white-space: nowrap;
  font-size: 12px;
  color: var(--tier2TextSubLv04);
  &:not(:first-child)::before {
    position: relative;
    margin: 0 7px;
    display: inline-block;
    width: 2px;
    top: -1px;
    vertical-align: middle;
    color: #777;
    content: '•';
  }
`;
const CreationYearWrapper = styled.div`
  float: right;
  color: #777;
  font-style: normal;
  font-size: 12px;
`;

const Footer = styled.footer`
  /* display: none; */
  position: relative;
  z-index: 1000;
  width: 100%;
  margin-top: 0;
  border-top: 1px solid rgba(0, 0, 0, 0.05);
  background: #fff;
`;
export {
  Container,
  InformationsWrapper,
  CreationYearWrapper,
  Information,
  Footer,
};
