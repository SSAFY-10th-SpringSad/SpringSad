import BandDetailPage from '@/pages/BandDetailPage/BandDetailPage';
import CreateBandPage from '@/pages/CreateBandPage/CreateBandPage';
import HomePage from '@/pages/HomePage/HomePage';
import Home from '@/pages/HomePage/HomePage';
import LoginPage from '@/pages/LoginPage/LoginPage';
import SignUpPage from '@/pages/SignUpPage/SignUpPage';
import React from 'react';
import { Route, Routes } from 'react-router-dom';

type Props = {};

export default function Router({}: Props) {
  return (
    <>
      <Routes>
        <Route path="/" element={<HomePage />}></Route>
        <Route path="/login" element={<LoginPage />}></Route>
        <Route path="/signup" element={<SignUpPage />}></Route>
        <Route path="/band:bandId" element={<BandDetailPage />}></Route>
        <Route path="/createBand" element={<CreateBandPage />}></Route>
      </Routes>
    </>
  );
}
