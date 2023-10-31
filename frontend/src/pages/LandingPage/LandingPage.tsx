import React from 'react';
import * as S from './LandingPage.styled';
import LinkButton from '@/components/Common/LongButton/LinkButton';
import { BROWSER_PATH } from '@/constants/path';
import Header from '@/components/Header/Header';
type Props = {};

export default function LandingPage({}: Props) {
  return (
    <>
      <Header />
      <S.Container>
        <S.Title>네이버 밴드 입니다.</S.Title>
        <LinkButton
          text="로그인"
          bgColor="white"
          fontColor="black"
          link={BROWSER_PATH.LOGIN}
        />
        <LinkButton
          text="회원가입"
          bgColor="white"
          fontColor="black"
          link={BROWSER_PATH.SIGN_UP}
        />
      </S.Container>
    </>
  );
}
