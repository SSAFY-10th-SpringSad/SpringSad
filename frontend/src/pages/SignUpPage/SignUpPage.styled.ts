import styled from '@emotion/styled';

const Wrapper = styled.main`
  width: 100vw;
  height: 100vh;
  background-color: #f7f8f9;
`;
const Form = styled.form`
  margin: 0 auto;
  width: 400px;
  padding: 15px;
  padding-top: 50px;
  height: auto;
  // background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  // font-weight: thin;

  input {
    background-color: transparent;
    border: none;
    &:: placeholder {
      color: lightgray;
    }
    &: focus {
      outline: none;
    }
    font-size: 30px;
    height: 30px;
  }
  select {
    background-color: transparent;
    &: focus {
      outline: none;
    }
  }
`;
const FormTitle = styled.div`
  width: 100%;
  padding: 15px;
  display: flex;
  justify-content: center;
  font-size: 40px;
`;
const InputContainer = styled.div`
  width: 100%;
  height: auto;
  padding: 15px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  // align-items: center;
  font-size: 40px;
`;
const PhoneNumberContainer = styled.div`
  width: 100%;
  height: 50px;
  display: flex;
  border-bottom: 1px solid lightgray;
  align-items: center;
`;
const TelePhoneCountryCode = styled.select`
  width: 20%;
  height: 30px;
  border: none;
`;
const PhoneNumberInput = styled.input`
  width: 80%;
  padding: 0 5px 0 10px;
  border-left: 1px solid lightgray;
`;

const PasswordContainer = styled.div`
  margin-top: 30px;
  width: 100%;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom: 1px solid lightgray;
`;
const PasswordInput = styled.input`
  width: 100%;
`;
const PasswordInputMessage = styled.p`
  font-size: 12px;
`;
const NameContainer = styled.div`
  width: 100%;
  height: 50px;
  display: flex;
  border-bottom: 1px solid lightgray;
  align-items: center;
  justify-content: center;
`;
const NameInput = styled.input`
  width: 100%;
`;
const BirthDateContainer = styled.div`
  margin-top: 30px;
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: column;

  // align-items: center;
  justify-content: center;
`;
const BirthDateLabel = styled.label``;
const BirthDateInputContainer = styled.div`
  width: 100%;
  height: 50px;
  display: flex;
  align-items: center;
`;

const YearSelectButton = styled.button`
  width: 40%;
  display: flex;
  height: 50px;
  margin-right: 10px;
  border-bottom: 1px solid lightgray;
`;
const MonthSelectButton = styled.button`
  width: 25%;
  display: flex;
  height: 50px;
  margin-right: 10px;
  border-bottom: 1px solid lightgray;
`;
const DaySelectButton = styled.button`
  width: 25%;
  display: flex;
  height: 50px;
  border-bottom: 1px solid lightgray;
`;

const SubmitButton = styled.button`
  width: 100%;
  height: 40px;
  background-color: lightgray;
  color: white;
`;
const SelectBox = styled.select`
  width: 70%;
  height: 40px;
  border: none;
  appearance: none;
`;
const Text = styled.span`
  width: 30%;
  font-size: 30px;
  color: lightgray;
`;
export {
  Wrapper,
  Form,
  FormTitle,
  InputContainer,
  PhoneNumberContainer,
  PasswordContainer,
  NameContainer,
  BirthDateContainer,
  SubmitButton,
  TelePhoneCountryCode,
  PhoneNumberInput,
  PasswordInput,
  PasswordInputMessage,
  NameInput,
  BirthDateLabel,
  YearSelectButton,
  MonthSelectButton,
  DaySelectButton,
  BirthDateInputContainer,
  SelectBox,
  Text,
};
