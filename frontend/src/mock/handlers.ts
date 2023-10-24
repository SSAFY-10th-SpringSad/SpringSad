import { HttpResponse, http } from 'msw';

export const handlers = [
  http.post('http://localhost:3000/login/*', ({ request }) => {
    console.log(request);
    return HttpResponse.json(
      {
        userId: 1,
      },
      { status: 200 },
    );
  }),
  http.post('http://localhost:3000/signup/*', ({ request }) => {
    console.log(request);
    return new HttpResponse(null, { status: 201 });
  }),
];

export default handlers;
