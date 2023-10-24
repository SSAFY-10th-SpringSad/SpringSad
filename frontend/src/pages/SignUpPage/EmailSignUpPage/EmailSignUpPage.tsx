import React, { ChangeEvent, useState } from 'react';
import * as S from './EmailSignUpPage.styled';
import Header from '@/components/Header/Header';
import { requestSignUp } from '@/apis/request/requestUser';
import { useNavigate } from 'react-router-dom';
import { BROWSER_PATH } from '@/constants/path';
type Props = {};

export default function SignUpPage({}: Props) {
  const navigate = useNavigate();

  const [userData, setUserData] = useState<RequestSignUpByEmailType>({
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

  const signup = (e: { preventDefault: () => void }) => {
    e.preventDefault();
    requestSignUp(userData, 'email')
      .then(() => {
        alert('회원가입 성공');
        navigate(BROWSER_PATH.LOGIN_BY_EMAIL);
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
                name="email"
                onChange={onChnageUserData}
              ></S.EmailInput>
            </S.EmailInputContainer>
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
          <S.SubmitButton onClick={signup}>확인</S.SubmitButton>
        </S.Form>
      </S.Wrapper>
    </>
  );
}
