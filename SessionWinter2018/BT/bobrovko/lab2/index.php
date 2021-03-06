<?php
/*
1.  Вывести название и версию используемой ОС.

2.  Объявить переменные следующих типов: 
•  целочисленную, 
•  строковую, 
•  дробную, 
•  логическую, 
•  массив.

3.  Объявить переменные $a=555 и $b="ZZZ" и сложить их: 
•  как числа, 
•  как строки. 
Результат сложения не помещать в новую переменную, а сразу выводить на экран.

4.  Есть три сотрудника:
Иванов, тел. 111-22-33, e-mail: ivanov@domain.com
Петров, тел. 112-24-36, e-mail: petrov@domain.com
Сидоров, тел. 113-25-37, e-mail: sidorov@domain.com
Объявить двухмерный массив:
1.  первый уровень которого пронумерован, начиная с нуля, 
2.  второй уровень содержит элементы name, phone, email, в которых хранятся соответствующие данные вышеназванных сотрудников. 
Вывести массив по уровням, указывая ключ в []. После ключа вывести символ « =», после которого указать значение элемента.

5.  Дан массив, содержащий элементы: 1, 2, "A", 3.764, 34, "B", 12. Объявить массив, вывести его, проанализировать содержимое и удалить из него все элементы, не являющиеся целыми или дробными числами. 

6.  Сгенерировать HTML-таблицу, состоящую из трёх колонок и 1000 строк. В первой колонке разместить номера строк таблицы. Цвет каждой строки таблицы должен изменяться по алгоритму: R+1, G+1, B+1, начиная с 000000: первая строка: 000000, вторая – 010101, третья -020202 и т.д. Замечание: числа – шестнадцатеричные и максимальное значение цвета составляет FFFFFF.

Дополнительное задание (по желанию).
Создать HTML-форму произвольного вида (побольше полей) и написать скрипт, который получает данные из этой формы и сохраняет их в файл в виде:
имя_поля = "значение поля"
имя_поля = "значение поля"
имя_поля = "значение поля"
*/
echo php_uname();
$int = 0;
$string = "";
$double = 0.0;
$boolean = false;
$array = [];

echo "<br>";
$a = 555;
$b = 'ZZZ';
echo $a + $b;
echo "<br>";
echo $a . $b;

$employers = [
    [
        "name" => "Иванов",
        "phone" => "111-22-33",
        "email" => "ivanov@domain.com"
    ],
    [
        "name" => "Петров",
        "phone" => "112-24-36",
        "email" => "petrov@domain.com"
    ],
    [
        "name" => "Сидоров",
        "phone" => "113-25-37",
        "email" => "sidorov@domain.com"
    ]
];
echo "<br>";
foreach ($employers as $index => $employer) {
    echo "[$index] ";
    foreach ($employer as $key => $info) {
        echo "[$key] = $info; ";
    }
    echo "<br>";
}

$numbers = [1, 2, "A", 3.764, 34, "B", 12];
$numbers = array_filter($numbers, function ($item) {
    return is_numeric($item);
});

echo '<pre>' . print_r($numbers, true) . '</pre>';
const ROW_COUNT = 1000;
const COL_COUNT = 3;
echo '<table width="500">';
for ($row = 0; $row < ROW_COUNT; $row++) {
    echo "<tr style='background-color: #" . dechex($row % 256) . dechex($row % 256) . dechex($row % 256) . "'>";
    for ($column = 0; $column < COL_COUNT; $column++) {
        echo "<td>" . (!$column ? $row : '') . "</td>";
    }
    echo "</tr>";

}
echo '</table>';