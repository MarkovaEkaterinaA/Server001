import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String recipient;
    private String content;
    private LocalDateTime timestamp;

    // Конструктор для создания сообщения
    public Message(String sender, String recipient, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = LocalDateTime.now();  // Текущая дата и время
    }

    // Геттеры и сеттеры для каждого поля
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Переопределение метода toString для удобного вывода
    @Override
    public String toString() {
        return "Message from: " + sender + " to: " + recipient + " at " + timestamp + "\nContent: " + content;
    }
}
