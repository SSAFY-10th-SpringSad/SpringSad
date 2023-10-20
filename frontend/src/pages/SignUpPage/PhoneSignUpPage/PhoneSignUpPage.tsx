import React from 'react';
import * as S from './PhoneSignUpPage.styled';
import Header from '@/components/Header/Header';
type Props = {};

export default function SignUpPage({}: Props) {
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
            <S.PhoneNumberContainer>
              <S.TelePhoneCountryCode>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
              </S.TelePhoneCountryCode>
              <S.PhoneNumberInput
                placeholder="휴대폰 번호"
                type="text"
                pattern="[0-9]+"
              ></S.PhoneNumberInput>
            </S.PhoneNumberContainer>
            <S.PasswordContainer>
              <S.PasswordInput
                placeholder="비밀번호"
                type="password"
              ></S.PasswordInput>
            </S.PasswordContainer>
            <S.PasswordInputMessage>
              8~16자 영문 대소문자, 숫자, 특수문자를 사용하세요.
            </S.PasswordInputMessage>
            <S.NameContainer>
              <S.NameInput placeholder="이름"></S.NameInput>
            </S.NameContainer>
            <S.BirthDateContainer>
              <S.BirthDateLabel>생년월일</S.BirthDateLabel>
              <S.BirthDateInputContainer>
                <S.YearSelectButton disabled>
                  <S.SelectBox>
                    {yearList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>년</S.Text>
                </S.YearSelectButton>
                <S.MonthSelectButton disabled>
                  <S.SelectBox>
                    {monthList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>월</S.Text>
                </S.MonthSelectButton>
                <S.DaySelectButton disabled>
                  <S.SelectBox>
                    {dayList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>일</S.Text>
                </S.DaySelectButton>
              </S.BirthDateInputContainer>
            </S.BirthDateContainer>
          </S.InputContainer>
          <S.SubmitButton>확인</S.SubmitButton>
        </S.Form>
      </S.Wrapper>
    </>
  );
}
