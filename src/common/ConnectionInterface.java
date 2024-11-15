package common;

public interface ConnectionInterface {
    void connectToServer(String ip, int port);
    void sendMessage(String message);
    String receiveMessage();
}

