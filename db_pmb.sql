-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Nov 2019 pada 14.37
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pmb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_info`
--

CREATE TABLE `tb_info` (
  `id_info` int(8) NOT NULL,
  `tgl_info` date NOT NULL,
  `judul_info` varchar(100) NOT NULL,
  `isi_info` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_konfirmasi`
--

CREATE TABLE `tb_konfirmasi` (
  `id_konfirm` int(8) NOT NULL,
  `tgl_bayar` date NOT NULL,
  `no_pendfataran` int(11) NOT NULL,
  `bukti_bayar` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pendaftaran`
--

CREATE TABLE `tb_pendaftaran` (
  `no_pendaftaran` int(11) NOT NULL,
  `nama_calon_siswa` varchar(75) NOT NULL,
  `tempat_lahir` varchar(75) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `kelamin` varchar(2) NOT NULL,
  `agama` varchar(2) NOT NULL,
  `no_telp` varchar(15) NOT NULL,
  `asal_sekolah` varchar(75) NOT NULL,
  `warga_negara` varchar(75) NOT NULL,
  `prestasi` varchar(100) NOT NULL,
  `tgl_daftar` date NOT NULL,
  `jalur_daftar` varchar(100) NOT NULL,
  `status_nikah` varchar(2) NOT NULL,
  `status_pembayaran` varchar(25) NOT NULL,
  `nama_ibu` varchar(75) NOT NULL,
  `pekerjaan_ibu` varchar(100) NOT NULL,
  `nama_ayah` varchar(75) NOT NULL,
  `pekerjaan_ayah` varchar(100) NOT NULL,
  `penghasilan_ortu` double NOT NULL,
  `gol_darah` varchar(5) NOT NULL,
  `tahus_lulus_sma` varchar(5) NOT NULL,
  `usn` varchar(20) NOT NULL,
  `usp` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_pendaftaran`
--

INSERT INTO `tb_pendaftaran` (`no_pendaftaran`, `nama_calon_siswa`, `tempat_lahir`, `tgl_lahir`, `alamat`, `kelamin`, `agama`, `no_telp`, `asal_sekolah`, `warga_negara`, `prestasi`, `tgl_daftar`, `jalur_daftar`, `status_nikah`, `status_pembayaran`, `nama_ibu`, `pekerjaan_ibu`, `nama_ayah`, `pekerjaan_ayah`, `penghasilan_ortu`, `gol_darah`, `tahus_lulus_sma`, `usn`, `usp`) VALUES
(1, 'Soleh', 'Pekanbaru', '2000-11-19', 'Jl. Paus No. 17', '1', '1', '085365879421', 'SMU Negeri 1 Pekanbaru', 'Indonresia', 'Bola Basket', '2019-05-14', 'Mandiri', '1', 'Belum Lunas', 'Surtini', 'IRT', 'Sukarjo', 'PNS', 60000000, 'A', '2019', 'soleh', 'soleh'),
(113, 'Rifda', '', '0000-00-00', '', '', '', '', '', '', '', '0000-00-00', '', '', '', '', '', '', '', 0, '', '', 'ida', 'ida'),
(112, 'nargaret', '', '0000-00-00', '', '', '', '', '', '', '', '0000-00-00', '', '', '', '', '', '', '', 0, '', '', 'marga', '123'),
(222, 'geri', '', '0000-00-00', '', '', '', '', '', '', '', '0000-00-00', '', '', '', '', '', '', '', 0, '', '', 'geri', '1234'),
(55, 'Julianto', '', '0000-00-00', '', '', '', '', '', '', '', '0000-00-00', '', '', '', '', '', '', '', 0, '', '', 'anto', 'anto'),
(44, 'ela', '', '0000-00-00', '', '', '', '', '', '', '', '0000-00-00', '', '', '', '', '', '', '', 0, '', '', 'ela', '1234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `usernama` varchar(20) NOT NULL,
  `userpass` varchar(10) NOT NULL,
  `level_user` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_info`
--
ALTER TABLE `tb_info`
  ADD PRIMARY KEY (`id_info`);

--
-- Indeks untuk tabel `tb_konfirmasi`
--
ALTER TABLE `tb_konfirmasi`
  ADD PRIMARY KEY (`id_konfirm`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_info`
--
ALTER TABLE `tb_info`
  MODIFY `id_info` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_konfirmasi`
--
ALTER TABLE `tb_konfirmasi`
  MODIFY `id_konfirm` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
