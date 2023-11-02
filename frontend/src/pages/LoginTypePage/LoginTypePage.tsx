import React from 'react';
import * as S from './LoginTypePage.styled';
import LinkButton from '@/components/Common/LongButton/LinkButton';
import { BROWSER_PATH, BROWSER_TYPE } from '@/constants/path';
type Props = {};

export default function LoginTypePage({}: Props) {
  return (
    <>
      <S.Container>
        <S.Title>로그인</S.Title>
        <LinkButton
          text="휴대폰 번호로 로그인"
          bgColor="white"
          fontColor="black"
          link={BROWSER_TYPE.PHONE}
        />
        <LinkButton
          text="이메일로 로그인"
          bgColor=""
          fontColor=""
          link={BROWSER_TYPE.EMAIL}
        />
      </S.Container>
    </>
  );
}
