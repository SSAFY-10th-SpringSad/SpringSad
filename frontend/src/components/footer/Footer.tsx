import * as S from './Footer.styled';

function Footer() {
  return (
    <S.Footer>
      <S.Container>
        <S.InformationsWrapper>
          <S.Information>블로그</S.Information>
          <S.Information>공지사항</S.Information>
          <S.Information>스티커제안</S.Information>
          <S.Information>광고</S.Information>
          <S.Information>이용약관</S.Information>
          <S.Information>개인정보처리방침</S.Information>
          <S.Information>쿠키 설정</S.Information>
          <S.Information>CCPA 개인 정보 관리</S.Information>
          <S.Information>청소년 보호를 위한 노력</S.Information>
          <S.Information>활동정책</S.Information>
          <S.Information>권리침해 신고안내</S.Information>
          <S.Information>개발자</S.Information>
          <S.Information>도움말</S.Information>
        </S.InformationsWrapper>
        <S.CreationYearWrapper>
          <strong>BAND</strong> @ 2023
        </S.CreationYearWrapper>
      </S.Container>
    </S.Footer>
  );
}

export default Footer;
