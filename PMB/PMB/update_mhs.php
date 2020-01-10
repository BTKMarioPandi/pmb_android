<?php
require_once 'Koneksi.php';


if($_SERVER['REQUEST_METHOD']=='POST')
{
	$NIM=$_POST['nim'];
	$NAMA=$_POST['nama'];
	$TEMPAT_LAHIR=$_POST['ttl'];
	$TGL_LAHIR=$_POST['tgl_lahir'];
	$ALAMAT=$_POST['ALAMAT'];
	$JENKEL=$_POST['jenis_kelamin'];
	$AGAMA=$_POST['agama'];
	$STATUS=$_POST['status'];
	$No_HP=$_POST['no_hp'];


	$ujidata="SELECT * FROM tb_mhs WHERE nim='" .$NIM. "'";

	$validasi=mysqli_query($konek,$ujidata);

	$result=mysqli_num_rows($validasi);

	if ($result == 0) {

		$kueri="INSERT INTO tb_mhs(nim,nama,ttl,tgl_lahir,agama,status,alamat,jenis_kelamin,no_hp) VALUES('$NIM','$NAMA','$TEMPAT_LAHIR','$TGL_LAHIR','$AGAMA','$STATUS','$ALAMAT','$JENKEL','$No_HP')";

			$exekueri=mysqli_query($konek,$kueri);

			echo json_encode(array('pesan'=>1,'kode'=>'Data berhasil disimpan.'));
	}else

	{
		
		$kueri="UPDATE tb_mhs SET nama='$NAMA',ttl='$TEMPAT_LAHIR',tgl_lahir='$TGL_LAHIR',agama='$AGAMA',status='$STATUS',alamat='$ALAMAT',jenis_kelamin='$JENKEL',no_hp='$NO' WHERE nim='$NIM'";
		

			$exekueri=mysqli_query($konek,$kueri);
			
			echo json_encode(array('pesan'=>2,'kode' =>'Data berhasil di-update.'));

	}

}

?>