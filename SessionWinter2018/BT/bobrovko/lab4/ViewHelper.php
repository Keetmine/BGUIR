<?php
include_once("DBHelper.php");

class ViewHelper
{
    private $dbHelper;
    private $config;

    public function __construct()
    {
        $this->dbHelper = new DBHelper();
        $this->initConfig();
    }

    private function initConfig()
    {
        $this->config = array_merge([
            "main_menu" => $this->buildMenu(),
            "today_d" => date("d"),
            "today_m" => date("m"),
            "today_y" => date("y"),
            "now_h" => date("H"),
            "now_m" => date("i"),
            "now_s" => date("s"),
            "news" => file_get_contents("templates/news.tpl"),
            "newsmenu" => $this->getNews(),
            "main_text" => file_get_contents("templates/main_text.tpl")
        ], json_decode(file_get_contents("site.cfg"), true));

    }

    private function replacePlaceHolders($textWithPlaceHolders, $arrayForReplace)
    {
        return str_replace(array_map(function ($item) {
            return "{" . strtoupper($item) . "}";
        }, array_keys($arrayForReplace)), $arrayForReplace, $textWithPlaceHolders);
    }

    private function getNews()
    {
        $news = $this->dbHelper->getNews();
        $result = "";
        foreach ($news as $newsItem) {
            $date = new DateTime($newsItem["date"]);
            $newsItem["date"] = $date->format("d ") . $this->getMounthByNumber($date->format("m")) . $date->format(" Y") . " г.";
            $result .= $this->replacePlaceHolders(file_get_contents("templates/one_news.tpl"), $newsItem);
        }
        return $result;
    }

    public function getTemplate()
    {
        return $this->replacePlaceHolders(file_get_contents("templates/main.tpl"), $this->config);
    }

    private function getMounthByNumber($number)
    {
        $mounthes = ["января", "февраля", "марта", "апреля",
            "мая", "июня", "июля", "августа",
            "сентября", "октября", "ноября", "декабря"];

        return $mounthes[$number - 1];
    }


    private function buildMenu()
    {
        return $this->drawMenu($this->dbHelper->getMenu());
    }

    private function drawMenu($menu, $level = 0)
    {
        $items = "";
        foreach ($menu as $menuItem) {
            $params = [
                "link" => "/" . $menuItem["id"],
                "title" => $menuItem['title'],
                "submenu" => isset($menuItem['submenu']) ? $this->drawMenu($menuItem['submenu'], $level + 1) : ""
            ];
            $items .= $this->replacePlaceHolders(file_get_contents("templates/menu_item.tpl"), $params);
        }

        $params = [
            "items" => $items,
            "level" => $level ? : ""
        ];
        return $this->replacePlaceHolders(file_get_contents("templates/main_menu.tpl"), $params);;

    }
}