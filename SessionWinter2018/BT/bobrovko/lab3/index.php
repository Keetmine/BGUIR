<?php
$main = file_get_contents("templates/main.tpl");
$config = json_decode(file_get_contents("site.cfg"), true);
date_default_timezone_set("Europe/Minsk");
$replace = [
    "main_menu" => file_get_contents("templates/main_menu.tpl"),
    "today_d"   => date("d"),
    "today_m"   => date("m"),
    "today_y"   => date("y"),
    "now_h"     => date("H"),
    "now_m"     => date("i"),
    "now_s"     => date("s"),
    "news"      => file_get_contents("templates/news.tpl"),
    "main_text" => file_get_contents("templates/main_text.tpl")
];
$replace += $config;
$main = str_replace(array_map(function($item){return "{".strtoupper($item)."}";}, array_keys($replace)), $replace, $main);

echo $main;