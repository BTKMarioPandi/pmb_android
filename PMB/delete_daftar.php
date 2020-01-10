<?php
require_once 'Koneksi.php';


if($_SERVER['REQUEST_METHOD']=='POST')
{
	$no_daftar=$_POST['no_pendaftaran'];
	
	$kueri="DELETE FROM tb_Pendaftaran WHERE no_pendaftaran = '$no_daftar'";

	$exekueri=mysqli_query($konek,$kueri);

		echo ($exekueri)? json_encode(array('pesan'=>1,'kode' =>'Data berhasil di-hapus.'))
		: json_encode(array('pesan'=>2,'kode'=>'Data gagal dihapus.'));

	
}else

{		
		json_encode(array('pesan'=>101,'kode'=>'request tidak valid.'));				
			
}

?>