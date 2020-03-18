<?php

include("config.php");

$judul = $_POST['judul'];
$waktu = $_POST['waktu'];
$penulis = $_POST['penulis'];
$isi = $_POST['isi'];

$sql = "INSERT INTO berita VALUES ( NULL,'$judul' , '$waktu', '$penulis','$isi' )";
$query = mysqli_query($db , $sql);

// apakah query update berhasil ?
if ($query) {
  // code...
} else {
  // kalau gagal tampilkan pesan
  die("Gagal menyimpan perubahan");
}
