//save.php(file two)
<?php
$username = $_POST['username'];
$password = $_POST['password'];
require_once('conn.php');

$sql = "INSERT INTO user (username, password) VALUES ('$username','$password')";

if($con -> query($sql) === TRUE) {
echo "User added";
}
//$con -> close();
?>
?>