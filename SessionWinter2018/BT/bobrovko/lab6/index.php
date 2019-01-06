<?php
header("Content-Type: text/xml");
header("Expires: Thu, 19 Feb 1998 13:24:18 GMT");
header("Last-Modified: " . gmdate("D, d M Y H:i:s") . " GMT");
header("Cache-Control: no-cache, must-revalidate");
header("Cache-Control: post-check=0,pre-check=0");
header("Cache-Control: max-age=0");
header("Pragma: no-cache");
$db = json_decode(file_get_contents("db.cfg"), true);
$mysql = new mysqli($db['host'], $db['user'], $db['password'], $db['database']);
$mysql->set_charset("utf8");
$news = [];
$result = $mysql->query("SELECT 
                                    title, 
                                    date, 
                                    CONCAT('" . $_SERVER["HTTP_HOST"] . "/news/newsid', id) AS link, 
                                    body AS description, 
                                    CONCAT('news/newsid', id) AS guid  
                                FROM news ORDER BY date ASC");
while ($data = $result->fetch_assoc()) {
    $news[] = $data;
}
$xml = new SimpleXMLElement("<xml/>");
$rss = $xml->addChild("rss");
$rss->addAttribute("version", "2.0");
$rss->addChild("title", "Лента новостей");
$rss->addChild("link", $_SERVER["HTTP_HOST"] . "/feed.xml");
$rss->addChild("description", "Описание ленты новстей");
$rss->addChild("lastBuild", gmdate("r"));
foreach ($news as $newsItem) {
    $item = $rss->addChild("item");
    foreach ($newsItem as $key => $newsPartItem) {
        if ($key == "date") {
            $date = (new DateTime($newsPartItem))->format("r");
            $item->addChild("pubDate", $date);
        } else {
            $item->addChild($key, $newsPartItem);
        }
    }
}
echo $xml->asXML();