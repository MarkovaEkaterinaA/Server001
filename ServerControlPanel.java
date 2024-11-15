import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerControlPanel {
    private boolean isServerWorking = false; // Переменная для отслеживания состояния сервера
    private JTextArea logArea; // JTextArea для вывода сообщений
    private JScrollPane scrollPane; // Для прокрутки текста в JTextArea

    public ServerControlPanel() {
        // Создание основного окна
        JFrame frame = new JFrame("Server Control Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Панель для кнопок управления сервером
        JPanel serverPanel = new JPanel();
        serverPanel.setLayout(new FlowLayout());

        // Кнопка для запуска сервера
        JButton startButton = new JButton("Start Server");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    appendLog("Server is already running");
                } else {
                    startServer();
                }
            }
        });

        // Кнопка для остановки сервера
        JButton stopButton = new JButton("Stop Server");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    appendLog("Server is not running");
                } else {
                    stopServer();
                }
            }
        });

        serverPanel.add(startButton);
        serverPanel.add(stopButton);

        // JTextArea для логов сервера
        logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);

        // Добавление области прокрутки для JTextArea
        scrollPane = new JScrollPane(logArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Панель с логами и кнопками
        frame.add(serverPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Отображение окна
        frame.setVisible(true);
    }

    // Метод для добавления текста в лог
    private void appendLog(String message) {
        logArea.append(message + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength()); // Прокручивает текст вниз
    }

    // Метод для запуска сервера
    private void startServer() {
        isServerWorking = true;
        appendLog("Server started");
    }

    // Метод для остановки сервера
    private void stopServer() {
        isServerWorking = false;
        appendLog("Server stopped");
    }

    public static void main(String[] args) {
        // Запуск интерфейса
        SwingUtilities.invokeLater(ServerControlPanel::new);
    }
}
