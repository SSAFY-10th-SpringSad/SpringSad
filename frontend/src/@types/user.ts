type RequestLoginUserType = {
  email: string;
  password: string;
};

type RequestEmailSignupUserType = {
  email: string;
  password: string;
  name: string;
  birth: {
    year: number;
    month: number;
    day: number;
  };
};

type RequestPhoneSignupUserType = {
  phone: string;
  password: string;
  name: string;
  birth: {
    year: number;
    month: number;
    day: number;
  };
};
