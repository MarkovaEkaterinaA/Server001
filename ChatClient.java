import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClient {
    public ChatClient() {
        // Создание основного окна
        JFrame frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Панель для ввода логина, пароля, IP и порта
        JPanel connectionPanel = new JPanel();
        connectionPanel.setLayout(new GridLayout(4, 2));

        JLabel loginLabel = new JLabel("Login:");
        JTextField loginField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel ipLabel = new JLabel("Server IP:");
        JTextField ipField = new JTextField();

        JLabel portLabel = new JLabel("Port:");
        JTextField portField = new JTextField();

        connectionPanel.add(loginLabel);
        connectionPanel.add(loginField);
        connectionPanel.add(passwordLabel);
        connectionPanel.add(passwordField);
        connectionPanel.add(ipLabel);
        connectionPanel.add(ipField);
        connectionPanel.add(portLabel);
        connectionPanel.add(portField);

        // Панель для чата
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());

        // JTextArea для вывода сообщений чата
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        chatPanel.add(scrollPane, BorderLayout.CENTER);

        // JTextField для ввода сообщений
        JTextField messageField = new JTextField();
        chatPanel.add(messageField, BorderLayout.SOUTH);

        // Кнопки для подключения и отправки сообщений
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика подключения к серверу
                System.out.println("Connecting to server at " + ipField.getText() + ":" + portField.getText());
            }
        });

        JButton sendButton = new JButton("Send Message");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логика отправки сообщения
                chatArea.append("Me: " + messageField.getText() + "\n");
                messageField.setText(""); // Очистка поля ввода
            }
        });

        buttonPanel.add(connectButton);
        buttonPanel.add(sendButton);

        // Добавление панелей в окно
        frame.add(connectionPanel, BorderLayout.NORTH);
        frame.add(chatPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Отображение окна
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Запуск интерфейса клиента
        SwingUtilities.invokeLater(ChatClient::new);
    }
}
