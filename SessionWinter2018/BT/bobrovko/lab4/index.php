<?php
header('Content-type: text/html; charset=utf-8');
date_default_timezone_set("Europe/Minsk");
include_once "ViewHelper.php";

$viewHelper = new ViewHelper();
echo $viewHelper->getTemplate();
