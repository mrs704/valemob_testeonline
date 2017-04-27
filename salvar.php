<?php
include"conectar.php";

$n1=$_POST['mercadoria'];
$c1=$_POST['nome'];
$e1=$_POST['quantidade'];
$d1=$_POST['tipo'];
$f1=$_POST('preco');
$t1=$_POST('tn')


$sql->query("INSERT INTO dados(nome,mercadoria,tipo,quantidade,preco,t1)

VALUES ('$c1','$n1','$d1','$e1','$f1','$tn')");

 echo"Cadastro Realizado </br>
		$c1</br>
		$n1</br>
		$d1</br>
		$e1</br>
		$f1</br>
		$tn</br>";
 

 
 ?>