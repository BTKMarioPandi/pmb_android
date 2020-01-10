<?php
require 'koneksi.php';

if($_SERVER['REQUEST_METHOD']=='POST')
{
	
	$usernama=$_POST['usn'];
	$userpass=$_POST['usp'];

		$test="SELECT * FROM tb_Pendaftaran WHERE usn = '$usernama' AND usp='$userpass'";

		$validasi=mysqli_query($konek,$test);

		$result=mysqli_num_rows($validasi);


		if ($result ==0) {
			
			
			echo json_encode(array('kode'=>2,'pesan'=>'Login Gagal!!!.'));
		}
		else
		{
			echo json_encode(array('kode'=>1,'pesan'=>'Login Sukses.'));
		}

}

?>
