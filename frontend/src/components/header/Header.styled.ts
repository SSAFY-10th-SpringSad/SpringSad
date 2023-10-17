import styled from '@emotion/styled';

const HeaderContainer = styled.header`
  width: 100vw;
  box-sizing: border-box;
  border-bottom: 1px solid #f2f2f2;
`;
const HeaderInner = styled.div`
  margin: 0 auto;
  width: 1100px;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

const LogoSearchWrapper = styled.div`
  display: flex;
  align-items: center;
  padding: 10px;
`;

const LogoWrapper = styled.div``;
const LogoImage = styled.img`
  width: 70px;
  height: 35px;
`;
const SearchWrapper = styled.div`
  margin-left: 10px;
  width: 300px;
  position: relative;
`;
const SearchInput = styled.input`
  width: 100%;
  padding: 8px 12px;
  border-radius: 20px;
  font-size: 12px;
  outline: none;
  background-color: #f5f6f8;
  border: 0;
  border: 1px solid lightgray;
`;
const SearchIconWrapper = styled.div`
  position: absolute;
  top: 15%;
  left: 90%;
  font-size: 15px;
`;

const WidgetWrapper = styled.div`
  display: flex;
  width: 330px;
  align-items: center;
  font-size: 18px;
  justify-content: space-evenly;
`;
const WidgetNewFeed = styled.div`
  display: flex;
  width: 70px;
  font-size: 13px;
  // border: 1px solid black;
  justify-content: center;
  cursor: pointer;
  &:hover {
    background-color: #f2f2f2;
  }
  border-radius: 15px;
  padding: 5px;
`;
const WidgetBandSearch = styled.div`
  padding: 5px;
  width: 70px;
  display: flex;
  font-size: 13px;
  // border: 1px solid black;
  justify-content: center;
  cursor: pointer;
  &:hover {
    background-color: #f2f2f2;
  }
  border-radius: 15px;
`;
const WidgetNews = styled.div`
  padding: 5px;
  width: 60px;
  display: flex;
  justify-content: center;
  // border: 1px solid black;
  color: gray;
  cursor: pointer;
  &:hover {
    background-color: #f2f2f2;
  }
  border-radius: 15px;
`;
const WidgetChat = styled.div`
  padding: 5px;
  width: 60px;
  display: flex;
  justify-content: center;
  // border: 1px solid black;
  color: gray;
  cursor: pointer;
  &:hover {
    background-color: #f2f2f2;
  }
  border-radius: 15px;
`;
const WidgetProfile = styled.div`
  padding: 5px;
  width: 60px;
  display: flex;
  justify-content: center;
  // border: 1px solid black;
  color: gray;
  cursor: pointer;
  &:hover {
    background-color: #f2f2f2;
  }
  border-radius: 15px;
`;
const LoginWrapper = styled.div`
  width: 80px;
  display: flex;
  justify-content: center;
`;

export {
  HeaderContainer,
  HeaderInner,
  LogoSearchWrapper,
  LogoWrapper,
  LogoImage,
  SearchWrapper,
  SearchIconWrapper,
  SearchInput,
  WidgetWrapper,
  WidgetNewFeed,
  WidgetBandSearch,
  WidgetChat,
  WidgetNews,
  WidgetProfile,
  LoginWrapper,
};
