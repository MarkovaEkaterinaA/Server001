import javax.swing.*;

public class ClientGUI {
    private ClientController controller;

    // Конструктор без передачи контроллера
    public ClientGUI() {
        // Здесь создаются все компоненты GUI (например, поля ввода, кнопки и т. д.)
        JFrame frame = new JFrame("Client Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Другие компоненты и настройки
    }

    // Метод для установки контроллера
    public void setController(ClientController controller) {
        this.controller = controller;
    }

    // Метод для отображения сообщений
    public void displayMessage(String message) {
        // Пример вывода сообщения в GUI
        System.out.println(message);
    }
}
