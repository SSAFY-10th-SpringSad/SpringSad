import Header from '@/components/Header/Header';
import * as S from './LoginPage.styled';
import { BROWSER_PATH } from '@/constants/path';
import useLogin from '@/hooks/useLogin';
import { useNavigate, useParams } from 'react-router-dom';

export default function LoginPage() {
  const { type } = useParams();
  const { onChangeEmail, onChangePhone, onChangePassword, login } = useLogin(
    type as string,
  );
  const navigate = useNavigate();

  return (
    <>
      <Header />
      <S.Container>
        <S.Content>
          <S.Title>로그인</S.Title>
          <S.Form>
            <S.FormWrap>
              <S.InputContainer>
                {type === 'email' && (
                  <S.InputWrapper>
                    <S.Label>이메일</S.Label>
                    <S.Input onChange={onChangeEmail} placeholder="이메일" />
                  </S.InputWrapper>
                )}
                {type === 'phone' && (
                  <S.InputWrapper>
                    <S.Label>핸드폰 번호</S.Label>
                    <S.Input onChange={onChangePhone} placeholder="번호" />
                  </S.InputWrapper>
                )}

                <S.InputWrapper>
                  <S.Label>패스워드</S.Label>
                  <S.Input onChange={onChangePassword} placeholder="비밀번호" />
                </S.InputWrapper>
              </S.InputContainer>
            </S.FormWrap>

            <S.LoginButton
              onClick={e => {
                if (login(e)) {
                  navigate(BROWSER_PATH.HOME);
                } else {
                  alert('로그인 실패');
                }
              }}
            >
              확인
            </S.LoginButton>
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
