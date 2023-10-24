type RequestLoginByEmailType = {
  email: string;
  password: string;
};

type RequestLoginByPhoneType = {
  phone: string;
  password: string;
};

type RequestSignUpByEmailType = {
  email: string;
  password: string;
  name: string;
  birth: {
    year: number;
    month: number;
    day: number;
  };
};

type RequestSignUpByPhoneType = {
  phone: string;
  password: string;
  name: string;
  birth: {
    year: number;
    month: number;
    day: number;
  };
};

//==============
type ResponseLogin = {
  userId: number;
};
