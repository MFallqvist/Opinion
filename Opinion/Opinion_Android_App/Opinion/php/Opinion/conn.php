 //conn.php for connection (file one)
<?php
$host = "localhost";
$user = "root";
$pass = "";
$db_name = "hello";

$con = new mysqli($host,$user,$pass,$db_name);

if($con -> connect_error){
echo "Connection error";
}   