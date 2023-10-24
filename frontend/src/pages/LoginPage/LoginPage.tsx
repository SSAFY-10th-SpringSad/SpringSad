import Header from '@/components/Header/Header';
import * as S from './LoginPage.styled';
import { BROWSER_PATH } from '@/constants/path';
import useLogin from '@/hooks/useLogin';

export default function LoginPage() {
  const { onChangeEmail, onChangePassword, loginByEmail } = useLogin();

  return (
    <>
      <Header />
      <S.Container>
        <S.Content>
          <S.Title>로그인</S.Title>
          <S.Form>
            <S.FormWrap>
              <S.InputContainer>
                <S.InputWrapper>
                  <S.Label>이메일</S.Label>
                  <S.Input onChange={onChangeEmail} placeholder="이메일" />
                </S.InputWrapper>
                <S.InputWrapper>
                  <S.Label>패스워드</S.Label>
                  <S.Input onChange={onChangePassword} placeholder="비밀번호" />
                </S.InputWrapper>
              </S.InputContainer>
            </S.FormWrap>

            <S.LoginButton onClick={loginByEmail}>확인</S.LoginButton>
          </S.Form>
          <S.NavigateSignUpWrapper>
            밴드가 처음이신가요?
            <S.NavigateSignUp to={BROWSER_PATH.SIGN_UP_BY_EMAIL}>
              회원가입
            </S.NavigateSignUp>
          </S.NavigateSignUpWrapper>
        </S.Content>
      </S.Container>
    </>
  );
}
