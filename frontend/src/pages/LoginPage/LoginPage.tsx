import Header from '@/components/Header/Header';
import * as S from './LoginPage.styled';
import { BROWSER_PATH } from '@/constants/path';

export default function LoginPage() {
  return (
    <>
      <Header />
      <S.Container>
        <S.Content>
          <S.Title>로그인</S.Title>
          <S.Form>
            <S.FormWrap>
              <S.InputWrapper>
                <S.EmailInput>
                  <S.EmailLabel>이메일</S.EmailLabel>
                  <S.Input placeholder="이메일" />
                </S.EmailInput>
              </S.InputWrapper>
            </S.FormWrap>

            <S.LoginButton>확인</S.LoginButton>
          </S.Form>
          <S.NavigateSignUpWrapper>
            밴드가 처음이신가요?
            <S.NavigateSignUp to={BROWSER_PATH.SIGN_UP}>
              회원가입
            </S.NavigateSignUp>
          </S.NavigateSignUpWrapper>
        </S.Content>
      </S.Container>
    </>
  );
}
