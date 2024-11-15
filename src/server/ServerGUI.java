import javax.swing.*;
import java.awt.*;

public class ServerGUI {
    private JTextArea textArea;
    private JButton startButton;
    private JButton stopButton;
    private ServerController controller;

    public ServerGUI(ServerController controller) {
        this.controller = controller;
        JFrame frame = new JFrame("Server Control Panel");
        textArea = new JTextArea(10, 30);
        startButton = new JButton("Start Server");
        stopButton = new JButton("Stop Server");

        frame.setLayout(new FlowLayout());
        frame.add(new JScrollPane(textArea));
        frame.add(startButton);
        frame.add(stopButton);

        startButton.addActionListener(e -> controller.startServer());
        stopButton.addActionListener(e -> controller.stopServer());

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void displayMessage(String message) {
        textArea.append(message + "\n");
    }
}
