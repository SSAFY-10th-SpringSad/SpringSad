import {
  faMagnifyingGlass,
  faBell,
  faComment,
  faUser,
} from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import * as S from './index.styled';
import logo from '../../assets/logo/bandLogo.png';

function Header() {
  return (
    <S.HeaderContainer>
      <S.HeaderInner>
        <S.LogoSearchWrapper>
          <S.LogoWrapper>
            <S.LogoImage src={logo} alt="Logo" />
          </S.LogoWrapper>
          <S.SearchWrapper>
            <S.SearchInput
              type="text"
              placeholder="밴드, 페이지, 게시글 검색"
            />
            <S.SearchIconWrapper>
              <FontAwesomeIcon icon={faMagnifyingGlass} />
            </S.SearchIconWrapper>
          </S.SearchWrapper>
        </S.LogoSearchWrapper>
        <S.WidgetWrapper>
          <S.WidgetNewFeed>새글 피드</S.WidgetNewFeed>
          <S.WidgetBandSearch>찾기</S.WidgetBandSearch>
          <S.WidgetNews>
            <FontAwesomeIcon icon={faBell} />
          </S.WidgetNews>
          <S.WidgetChat>
            <FontAwesomeIcon icon={faComment} />
          </S.WidgetChat>
          <S.WidgetProfile>
            <FontAwesomeIcon icon={faUser} />
          </S.WidgetProfile>
        </S.WidgetWrapper>
      </S.HeaderInner>
    </S.HeaderContainer>
  );
}

export default Header;
