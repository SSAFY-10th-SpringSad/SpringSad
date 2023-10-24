import * as S from './SignUpPage.styled';
import Header from '@/components/Header/Header';
import { useNavigate, useParams } from 'react-router-dom';
import useSignup from '@/hooks/useSignup';
type Props = {};

export default function SignUpPage({}: Props) {
  const { type } = useParams();
  const { onChnageUserData, signup } = useSignup(type as string);
  const onClickSignup = async (e: { preventDefault: () => void }) => {
    e.preventDefault();
    signup();
  };

  const year = new Date().getFullYear();
  const yearList = [...new Array(100)].map((_, i) => year - i);
  const monthList = [...new Array(12)].map((_, i) => i + 1);
  const dayList = [...new Array(30)].map((_, i) => i + 1);
  return (
    <>
      <Header />
      <S.Wrapper>
        <S.Form>
          <S.FormTitle>회원가입</S.FormTitle>
          <S.InputContainer>
            {type === 'email' && (
              <S.EmailInputContainer>
                <S.EmailInput
                  placeholder="이메일"
                  type="text"
                  name="email"
                  onChange={onChnageUserData}
                ></S.EmailInput>
              </S.EmailInputContainer>
            )}
            {type === 'phone' && (
              <S.PhoneNumberContainer>
                <S.TelePhoneCountryCode>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                </S.TelePhoneCountryCode>
                <S.PhoneNumberInput
                  onChange={onChnageUserData}
                  placeholder="휴대폰 번호"
                  type="text"
                  pattern="[0-9]+"
                ></S.PhoneNumberInput>
              </S.PhoneNumberContainer>
            )}

            <S.PasswordContainer>
              <S.PasswordInput
                onChange={onChnageUserData}
                placeholder="비밀번호"
                name="password"
                type="password"
              ></S.PasswordInput>
            </S.PasswordContainer>
            <S.PasswordInputMessage>
              8~16자 영문 대소문자, 숫자, 특수문자를 사용하세요.
            </S.PasswordInputMessage>
            <S.NameContainer>
              <S.NameInput
                placeholder="이름"
                name="name"
                onChange={onChnageUserData}
              ></S.NameInput>
            </S.NameContainer>
            <S.BirthDateContainer>
              <S.BirthDateLabel>생년월일</S.BirthDateLabel>
              <S.BirthDateInputContainer>
                <S.YearSelectButton disabled>
                  <S.SelectBox name="birth.year" onChange={onChnageUserData}>
                    {yearList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>년</S.Text>
                </S.YearSelectButton>
                <S.MonthSelectButton disabled>
                  <S.SelectBox name="birth.month" onChange={onChnageUserData}>
                    {monthList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>월</S.Text>
                </S.MonthSelectButton>
                <S.DaySelectButton disabled>
                  <S.SelectBox name="birth.day" onChange={onChnageUserData}>
                    {dayList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>일</S.Text>
                </S.DaySelectButton>
              </S.BirthDateInputContainer>
            </S.BirthDateContainer>
          </S.InputContainer>
          <S.SubmitButton onClick={onClickSignup}>확인</S.SubmitButton>
        </S.Form>
      </S.Wrapper>
    </>
  );
}
