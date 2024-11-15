public class ClientController {
    private ClientGUI gui;
    private ClientConnection connection;

    public ClientController(ClientGUI gui, ClientConnection connection) {
        this.gui = gui;
        this.connection = connection;
    }

    // Методы для обработки логики, например, отправка и получение сообщений
    public void sendMessage(String message) {
        connection.sendMessage(message);
        gui.displayMessage("Sent: " + message);
    }

    public void listenForMessages() {
        String message = connection.receiveMessage();
        if (message != null) {
            gui.displayMessage("Received: " + message);
        }
    }
}
