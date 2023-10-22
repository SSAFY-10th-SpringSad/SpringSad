import React, { ChangeEvent, useState } from 'react';
import * as S from './EmailSignUpPage.styled';
import Header from '@/components/Header/Header';
import { requestSignUp } from '@/apis/request/requestUser';
type Props = {};

export default function SignUpPage({}: Props) {
  const [userData, setUserData] = useState<RequestEmailSignupUserType>({
    email: '',
    password: '',
    name: '',
    birth: {
      year: 0,
      month: 0,
      day: 0,
    },
  });

  const onChnageUserData = (
    e: ChangeEvent<HTMLInputElement | HTMLSelectElement>,
  ) => {
    const { name, value } = e.target;
    if (name.startsWith('birth.')) {
      const fieldName = name.split('.')[1];
      setUserData(prevData => ({
        ...prevData,
        birth: {
          ...prevData.birth,
          [fieldName]: value,
        },
      }));
    } else {
      setUserData({
        ...userData,
        [name]: value,
      });
    }
  };

  const signup = () => {
    requestSignUp(userData)
      .then(() => {
        alert('회원가입 성공');
      })
      .catch(err => {
        console.log(err);
      });
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
            <S.EmailInputContainer>
              <S.EmailInput
                placeholder="이메일"
                type="text"
                onChange={onChnageUserData}
              ></S.EmailInput>
            </S.EmailInputContainer>
            <S.PasswordContainer>
              <S.PasswordInput
                onChange={onChnageUserData}
                placeholder="비밀번호"
                type="password"
              ></S.PasswordInput>
            </S.PasswordContainer>
            <S.PasswordInputMessage>
              8~16자 영문 대소문자, 숫자, 특수문자를 사용하세요.
            </S.PasswordInputMessage>
            <S.NameContainer>
              <S.NameInput
                placeholder="이름"
                onChange={onChnageUserData}
              ></S.NameInput>
            </S.NameContainer>
            <S.BirthDateContainer>
              <S.BirthDateLabel>생년월일</S.BirthDateLabel>
              <S.BirthDateInputContainer>
                <S.YearSelectButton disabled>
                  <S.SelectBox onChange={onChnageUserData}>
                    {yearList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>년</S.Text>
                </S.YearSelectButton>
                <S.MonthSelectButton disabled>
                  <S.SelectBox onChange={onChnageUserData}>
                    {monthList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>월</S.Text>
                </S.MonthSelectButton>
                <S.DaySelectButton disabled>
                  <S.SelectBox onChange={onChnageUserData}>
                    {dayList.map((e, i) => {
                      return <option>{e}</option>;
                    })}
                  </S.SelectBox>
                  <S.Text>일</S.Text>
                </S.DaySelectButton>
              </S.BirthDateInputContainer>
            </S.BirthDateContainer>
          </S.InputContainer>
          <S.SubmitButton onClick={signup}>확인</S.SubmitButton>
        </S.Form>
      </S.Wrapper>
    </>
  );
}
