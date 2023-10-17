import * as S from './index.styled';

function Header() {
  return (
    <S.Container>
      <S.LogoSearchWrapper>
        <S.LogoWrapper>logo</S.LogoWrapper>
        <S.SearchWrapper>
          <input />
        </S.SearchWrapper>
      </S.LogoSearchWrapper>
      <S.OptionWrapper>
        {true ? (
          <S.LogOutWrapper>logoutOptions</S.LogOutWrapper>
        ) : (
          <S.LoginWrapper>loginOptions</S.LoginWrapper>
        )}
      </S.OptionWrapper>
    </S.Container>
  );
}

export default Header;
