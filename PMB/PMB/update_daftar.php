<?php
require_once 'Koneksi.php';


if($_SERVER['REQUEST_METHOD']=='POST')
{
	$no_daftar=$_POST['no_pendaftaran'];
	$namaSiswa=$_POST['nama_calon_siswa'];
	$usernama=$_POST['usn'];
	$userpass=$_POST['usp'];


	$ujidata="SELECT * FROM tb_Pendaftaran WHERE no_pendaftaran = '$no_daftar'";

	$validasi=mysqli_query($konek,$ujidata);

	$result=mysqli_num_rows($validasi);

	if ($result == 0) {

		$kueri="INSERT INTO tb_Pendaftaran(no_pendaftaran,nama_calon_siswa,usn,usp) VALUES('$no_daftar','$namaSiswa','$usernama','$userpass')";

			$exekueri=mysqli_query($konek,$kueri);

			echo json_encode(array('pesan'=>1,'kode'=>'Data berhasil disimpan.'));
	}else

	{
		
		$kueri="UPDATE tb_Pendaftaran SET nama_calon_siswa='$namaSiswa',usn='$usernama',usp='$userpass'";
		

			$exekueri=mysqli_query($konek,$kueri);
			
			echo json_encode(array('pesan'=>2,'kode' =>'Data berhasil di-update.'));

	}

}

?>