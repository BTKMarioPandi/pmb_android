<?php
require_once 'koneksi.php';


$kueri ="SELECT * FROM tb_pendaftaran ORDER BY nama_calon_siswa";

$result =mysqli_query($konek,$kueri);

$ketemu =mysqli_num_rows($result);

if ($ketemu ==0) 
{
	echo json_encode(array("kode"=>2,"result"=>"Data tidak ditemukan!"));
}
	else
{
	while ($row=mysqli_fetch_assoc($result)) {
		$array[]=$row;
		
	}

	echo json_encode(array("kode"=>1,"result"=>$array));
}
mysqli_close($konek);

?>