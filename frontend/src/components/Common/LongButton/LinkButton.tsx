import React from 'react';
import * as S from './LinkButton.styled';
type Props = {
  text: string;
  bgColor: string;
  fontColor: string;
  link: string;
};
/**
 * 링크 역할을 하는 공통 컴포넌트 입니다.
 * @param text : 컴포넌트 내부에 들어갈 글씨
 * @param bgColor : 컴포넌트의 배경 색
 * @param fontColor : 컴포넌트의 글자 색
 * @param link : 컴포넌트를 눌럿을 때 이동할 경로
 * @returns
 */
export default function LinkButton({
  text = 'default',
  bgColor = 'gray',
  fontColor = 'white',
  link = '/',
}: Props) {
  return (
    <S.Container bgColor={bgColor} fontColor={fontColor} to={link}>
      {text}
    </S.Container>
  );
}
