<?php

class DBHelper
{
    private $mysql;


    public function __construct()
    {
        $db = json_decode(file_get_contents("db.cfg"), true);
        $this->mysql = new mysqli($db['host'], $db['user'], $db['password'], $db['database']);
        $this->mysql->set_charset("utf8");
        if ($this->mysql->connect_error) {
            die('Connection error');
        }
    }


    public function getNews($count = 3)
    {
        $count = (int)$count ? (int)$count : 3;
        $result = $this->mysql->query("SELECT * FROM news ORDER BY date DESC LIMIT $count");
        $news = [];
        while ($data = $result->fetch_assoc()) {
            $news[] = $data;
        }
        return $news;
    }

    public function getMenu()
    {
        $menu = [];
        $result = $this->mysql->query("SELECT * FROM pages");
        while ($data = $result->fetch_assoc()) {
            $menu[] = $data;
        }
        return $this->formatMenu($menu);
    }

    private function formatMenu($menu, $parentId = null)
    {
        $result = [];
        foreach ($menu as $menuItem) {
            if ($parentId == $menuItem["parent_id"]) {
                $result[] = $menuItem;
                if ($submenu = $this->formatMenu($menu, $menuItem['id'])) {
                    $result[count($result) - 1]['submenu'] = $submenu;
                }
            }
        }

        return $result;
    }

}