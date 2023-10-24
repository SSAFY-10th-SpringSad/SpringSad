import Axios from 'axios';

const baseURL = process.env.BASE_URL;

const axios = Axios.create({
  baseURL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export { baseURL, axios };
