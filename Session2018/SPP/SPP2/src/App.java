import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class App {
    private JPanel panel1;
//
//    //Массив содержащий заголоки таблицы
//    Object[] headers = { "Name", "Surname", "Telephone", "image" };
//
//    //Массив содержащий информацию для таблицы
//    Object[][] data = {
//            { "John", "Smith", "1112221", new ImageIcon("example.jpg") },
//            { "Ivan", "Black", "2221111", new ImageIcon("example.jpg") },
//            { "George", "White", "3334444", new ImageIcon("example.jpg") },
//            { "Bolvan", "Black", "2235111", new ImageIcon("example.jpg") },
//            { "Serg", "Black", "2221511", new ImageIcon("example.jpg") },
//            { "Pussy", "Black", "2221111", new ImageIcon("example.jpg") },
//            { "Tonya", "Red", "2121111", new ImageIcon("example.jpg") },
//            { "Elise", "Green", "2321111", new ImageIcon("example.jpg") },
//    };
//
//    //Объект таблицы
//    JTable jTabPeople;
//
//    App() {
//        //Создаем новый контейнер JFrame
//        JFrame jfrm = new JFrame("SPP 2");
//        //Устанавливаем диспетчер компоновки
//        jfrm.getContentPane().setLayout(new FlowLayout());
//        //Устанавливаем размер окна
//        jfrm.setSize(600, 400);
//        //Устанавливаем завершение программы при закрытии окна
//        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //Создаем новую таблицу на основе двумерного массива данных и заголовков
//        jTabPeople = new JTable(data, headers);
//        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
//        JScrollPane jscrlp = new JScrollPane(jTabPeople);
//        //Устаналиваем размеры прокручиваемой области
//        jTabPeople.setPreferredScrollableViewportSize(new Dimension(580, 400));
//        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
//        jfrm.getContentPane().add(jscrlp);
//        //Отображаем контейнер
//        jfrm.setVisible(true);
//    }
//
//    //Функция main, запускающаяся при старте приложения
//    public static void main(String[] args) {
//        //Создаем фрейм в потоке обработки событий
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new App();
//            }
//        });
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());

        MyTableModel model = new MyTableModel();

        JTable table = new JTable(model);
        table.setRowHeight(80);
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        JScrollPane pane = new JScrollPane(table);
        frame.getContentPane().add(BorderLayout.CENTER, pane);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }




}

class MyTableModel extends AbstractTableModel {



    public Object getValueAt(int row, int column) {
        return "" + (row * column);
    }


    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return 5;
    }
}

class ImageRenderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();

    ImageIcon icon = new ImageIcon("example.jpg");

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        lbl.setText((String) value);
        lbl.setIcon(icon);
        return lbl;
    }
}