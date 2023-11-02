import React from 'react';
import * as S from './SignUpTypePage.styled';
import LinkButton from '@/components/Common/LongButton/LinkButton';
import { BROWSER_TYPE } from '@/constants/path';
type Props = {};

export default function SignUpTypePage({}: Props) {
  return (
    <S.Container>
      <S.Title>회원가입</S.Title>
      <LinkButton
        text="휴대폰 번호로 회원가입"
        bgColor="white"
        fontColor="black"
        link={BROWSER_TYPE.PHONE}
      />
      <LinkButton
        text="이메일로 회원가입"
        bgColor="white"
        fontColor="black"
        link={BROWSER_TYPE.EMAIL}
      />
    </S.Container>
  );
}
