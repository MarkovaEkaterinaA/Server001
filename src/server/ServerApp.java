public class ServerApp {
    public static void main(String[] args) {
        ServerRepository repository = new ServerRepository();
        ServerGUI gui = new ServerGUI(new ServerController(gui, repository));
    }
}
