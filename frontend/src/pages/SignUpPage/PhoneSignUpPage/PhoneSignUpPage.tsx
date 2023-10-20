import React, { ReactHTMLElement, useState } from 'react';
import * as S from './PhoneSignUpPage.styled';
import Header from '@/components/Header/Header';
type Props = {};

export default function PhoneSignUpPage({}: Props) {
  // states
  const [phoneNumber, setPhoneNumber] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [name, setName] = useState<string>('');
  const [year, setYear] = useState<string>('');
  const [month, setMonth] = useState<string>('');
  const [day, setDay] = useState<string>('');
  // Debug
  console.log(phoneNumber);
  //functions
  const onChangePhoneNumberHandler = (
    e: React.ChangeEvent<HTMLInputElement>,
  ) => {
    setPhoneNumber(e.target.value);
  };
  const onChangePasswordHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(e.target.value);
  };
  const onChangeNameHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setName(e.target.value);
  };
  const onChangeYearHandler = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setYear(e.target.value);
  };
  const onChangeMonthHandler = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setMonth(e.target.value);
  };
  const onChangeDayHandler = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setDay(e.target.value);
  };

  const validatePhoneNumber = () => {};
  const validatePassword = () => {};
  const validateName = () => {};
  // 생년월일로 가능한 숫자 리스트
  const yearList = [...new Array(100)].map(
    (_, i) => new Date().getFullYear() - i,
  );
  const monthList = [...new Array(12)].map((_, i) => i + 1);
  const dayList = [...new Array(30)].map((_, i) => i + 1);

  // 전화번호, 비밀번호, 생년월일 유효성 검사
  const isVaildPhoneNumber = validatePhoneNumber();
  const isValidPassword = validatePassword();
  const isValidName = validateName();

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
                onChange={onChangePhoneNumberHandler}
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
                      return <S.Option key={i}>{e}</S.Option>;
                    })}
                  </S.SelectBox>
                  <S.Text>년</S.Text>
                </S.YearSelectButton>
                <S.MonthSelectButton disabled>
                  <S.SelectBox>
                    {monthList.map((e, i) => {
                      return <S.Option key={i}>{e}</S.Option>;
                    })}
                  </S.SelectBox>
                  <S.Text>월</S.Text>
                </S.MonthSelectButton>
                <S.DaySelectButton disabled>
                  <S.SelectBox>
                    {dayList.map((e, i) => {
                      return <S.Option key={i}>{e}</S.Option>;
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
