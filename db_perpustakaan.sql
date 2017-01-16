/*
SQLyog Enterprise - MySQL GUI v7.14 
MySQL - 5.5.5-10.1.10-MariaDB : Database - db_perpustakaan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_perpustakaan` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_perpustakaan`;

/*Table structure for table `tbl_buku` */

DROP TABLE IF EXISTS `tbl_buku`;

CREATE TABLE `tbl_buku` (
  `kodebuku` char(15) NOT NULL,
  `kodejenis` char(15) DEFAULT NULL,
  `kodekategori` char(15) DEFAULT NULL,
  `judul` varchar(50) DEFAULT NULL,
  `pengarang` varchar(50) DEFAULT NULL,
  `kodepenerbit` char(15) DEFAULT NULL,
  `tahun` int(11) DEFAULT NULL,
  `jumlahbuku` int(11) DEFAULT NULL,
  PRIMARY KEY (`kodebuku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_buku` */

insert  into `tbl_buku`(`kodebuku`,`kodejenis`,`kodekategori`,`judul`,`pengarang`,`kodepenerbit`,`tahun`,`jumlahbuku`) values ('KB002','KJ001','KK001','Metode Numerik','Risa Achmad','KP002',2003,10);

/*Table structure for table `tbl_jenis` */

DROP TABLE IF EXISTS `tbl_jenis`;

CREATE TABLE `tbl_jenis` (
  `kodejenis` char(15) NOT NULL,
  `namajenis` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`kodejenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_jenis` */

/*Table structure for table `tbl_kategori` */

DROP TABLE IF EXISTS `tbl_kategori`;

CREATE TABLE `tbl_kategori` (
  `kodekategori` char(15) NOT NULL,
  `namakategori` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`kodekategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_kategori` */

/*Table structure for table `tbl_kembali` */

DROP TABLE IF EXISTS `tbl_kembali`;

CREATE TABLE `tbl_kembali` (
  `id_pengembalian` char(10) NOT NULL,
  `id_pinjam` char(5) DEFAULT NULL,
  `terlambat` int(10) DEFAULT NULL,
  `denda` int(20) DEFAULT NULL,
  PRIMARY KEY (`id_pengembalian`),
  KEY `FK_tbl_kembali` (`id_pinjam`),
  CONSTRAINT `FK_tbl_kembali` FOREIGN KEY (`id_pinjam`) REFERENCES `tbl_pinjam1` (`id_pinjam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_kembali` */

/*Table structure for table `tbl_penerbit` */

DROP TABLE IF EXISTS `tbl_penerbit`;

CREATE TABLE `tbl_penerbit` (
  `kodepenerbit` char(15) NOT NULL,
  `namapenerbit` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `kota` varchar(50) DEFAULT NULL,
  `nope` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`kodepenerbit`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_penerbit` */

/*Table structure for table `tbl_pinjam1` */

DROP TABLE IF EXISTS `tbl_pinjam1`;

CREATE TABLE `tbl_pinjam1` (
  `id_pinjam` char(5) NOT NULL,
  `nis` char(15) DEFAULT NULL,
  `kode_buku` char(10) DEFAULT NULL,
  `tanggal_pinjam` varchar(20) DEFAULT NULL,
  `tanggal_kembali` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_pinjam`),
  KEY `FK_tbl_pinjam` (`nis`),
  KEY `FK_tbl_pinjam1` (`kode_buku`),
  CONSTRAINT `FK_tbl_pinjam` FOREIGN KEY (`nis`) REFERENCES `tbl_siswa` (`nis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_pinjam1` */

/*Table structure for table `tbl_siswa` */

DROP TABLE IF EXISTS `tbl_siswa`;

CREATE TABLE `tbl_siswa` (
  `nis` char(15) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `kelas` varchar(20) DEFAULT NULL,
  `jeniskelamin` varchar(20) DEFAULT NULL,
  `kotalahir` varchar(30) DEFAULT NULL,
  `tanggallahir` date DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `telepon` varchar(15) DEFAULT NULL,
  `tanggalregister` date DEFAULT NULL,
  `akhirregister` date DEFAULT NULL,
  PRIMARY KEY (`nis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_siswa` */

insert  into `tbl_siswa`(`nis`,`nama`,`kelas`,`jeniskelamin`,`kotalahir`,`tanggallahir`,`alamat`,`telepon`,`tanggalregister`,`akhirregister`) values ('8824','raushan','c','laki-laki',NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
