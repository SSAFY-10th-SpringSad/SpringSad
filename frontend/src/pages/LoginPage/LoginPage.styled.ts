import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Container = styled.div``;
const Content = styled.div`
  position: relative;
  max-width: 394px;
  padding: 0 17px;
  margin: 67px auto 40px;
`;

const Title = styled.h1`
  position: relative;
  margin: 0 -17px;
  text-align: center;
  font-size: 36px;
  font-weight: 300;
  letter-spacing: -1px;
  color: #222;
  line-height: 1.2;
  word-break: keep-all;
  word-wrap: break-word;
`;
const Form = styled.form`
  display: block;
  margin-top: 0em;
`;

const FormWrap = styled.div`
  margin: 63px 0 34px;
`;
const InputWrapper = styled.div`
  border-bottom-color: #666;
  position: relative;
  border-bottom: 1px solid #ccc;
`;

const EmailInput = styled.div`
  margin-bottom: 10px;
  display: -webkit-box;
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  position: relative;
  width: 100%;
  height: 36px;
  vertical-align: top;
`;

const Input = styled.input`
  overflow: hidden;
  -webkit-box-flex: 1;
  flex: 1 0;
  width: 100%;
  height: 100%;
  padding: 0;
  border: 0;
  background: 0 0;
  font-size: 30px;
  font-weight: 300;
  -o-text-overflow: ellipsis;
  text-overflow: ellipsis;
  letter-spacing: -0.4px;

  color: #333;
  outline: 0;

  line-height: normal;
`;

const EmailLabel = styled.label`
  overflow: hidden !important;
  position: absolute !important;
  height: 1px !important;
  width: 1px !important;
  clip: rect(1px, 1px, 1px, 1px);
`;
const LoginButton = styled.button`
  position: relative;
  overflow: hidden;
  display: inline-block;
  width: 100%;
  height: 54px;
  border-radius: 2px;
  border: 1px solid transparent;
  color: #fff;
  font-size: 16px;
  text-align: center;
  line-height: 1;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  word-break: break-all;
  background: #474e60;
`;

const NavigateSignUpWrapper = styled.div`
  margin: 16px 0 0 0;
  color: #333;
  font-size: 14px;
  line-height: 1.57;
  text-align: center;
`;

const NavigateSignUp = styled(Link)`
  margin-left: 15px;
  color: #333;
`;

export {
  Container,
  Title,
  Form,
  InputWrapper,
  LoginButton,
  EmailInput,
  NavigateSignUpWrapper,
  NavigateSignUp,
  EmailLabel,
  Input,
  FormWrap,
  Content,
};
