<?php
require_once 'Koneksi.php';


if($_SERVER['REQUEST_METHOD']=='POST')
{
	$NIM=$_POST['nim'];
	

	$kueri="DELETE FROM tb_mhs WHERE nim='" .$NIM. "'";

	$exekueri=mysqli_query($konek,$kueri);

		echo ($exekueri)? json_encode(array('pesan'=>1,'kode' =>'Data berhasil di-hapus.'))
		: json_encode(array('pesan'=>2,'kode'=>'Data gagal dihapus.'));

	
}else

{		
		json_encode(array('pesan'=>101,'kode'=>'request tidak valid.'));				
			
}


?>