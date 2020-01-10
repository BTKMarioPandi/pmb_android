<?php
require 'koneksi.php';

if($_SERVER['REQUEST_METHOD']=='POST')
{
	$no_daftar=$_POST['no_pendaftaran'];
	$namaSiswa=$_POST['nama_calon_siswa'];
	$usernama=$_POST['usn'];
	$userpass=$_POST['usp'];

		$test="SELECT * FROM tb_Pendaftaran WHERE no_pendaftaran = '$no_daftar' OR nama_calon_siswa='$namaSiswa'";

		$validasi=mysqli_query($konek,$test);

		$result=mysqli_num_rows($validasi);


		if ($result ==0) {
			
			$simpan="INSERT INTO tb_pendaftaran(no_pendaftaran,nama_calon_siswa,usn,usp) VALUES('$no_daftar','$namaSiswa','$usernama','$userpass')";

			$exesimpan=mysqli_query($konek,$simpan);

			echo json_encode(array('kode'=>1,'pesan'=>'Data Berhasil disimpan.'));
		}
		else
		{
			echo json_encode(array('kode'=>2,'pesan'=>'Data sudah ada.'));
		}

}

?>
