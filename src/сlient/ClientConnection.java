import java.io.*;
import java.net.*;

public class ClientConnection {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClientConnection(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для получения сообщения от сервера
    public String receiveMessage() {
        try {
            return input.readLine();  // Чтение строки от сервера
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Метод для отправки сообщения на сервер
    public void sendMessage(String message) {
        output.println(message);  // Отправка строки на сервер
    }

    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
