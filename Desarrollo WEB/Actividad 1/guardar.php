<?php
$archivo = "datos.txt";
$dato = isset($_POST["dato"]) ? $_POST["dato"] : "";
$dato = trim($dato);
if ($dato !== "") {
  file_put_contents($archivo, $dato . PHP_EOL, FILE_APPEND);
}
$contenido = file_exists($archivo) ? file_get_contents($archivo) : "";
?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Datos Guardados</title>
  <style>
    body { font-family: Arial, sans-serif; background: #f0f0f0; padding: 40px; }
    pre  { background: #fff; border: 1px solid #ccc; border-radius: 5px; padding: 15px; }
    a    { display: inline-block; margin-top: 10px; }
  </style>
</head>
<body>
  <h2>Contenido del archivo:</h2>
  <pre><?php echo htmlspecialchars($contenido); ?></pre>
  <a href="index.html">Volver</a>
</body>
</html>
