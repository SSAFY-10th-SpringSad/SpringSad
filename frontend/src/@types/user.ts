type RequestLoginUserType = {
  email: string;
  password: string;
};

type RequestSignupUserType = {
  email: string;
  password: string;
  name: string;
  birth: {
    year: number;
    month: number;
    day: number;
  };
};
