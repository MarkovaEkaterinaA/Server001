public class ServerController implements ServerInterface {
    private ServerRepository repository;
    private ServerGUI gui;

    public ServerController(ServerGUI gui, ServerRepository repository) {
        this.gui = gui;
        this.repository = repository;
    }

    @Override
    public void startServer() {
        gui.displayMessage("Server is starting...");
        // Логика запуска сервера
    }

    @Override
    public void stopServer() {
        gui.displayMessage("Server is stopping...");
        // Логика остановки сервера
    }

    @Override
    public void logMessage(String message) {
        gui.displayMessage(message);
    }
}
