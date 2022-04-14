package course2.homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean isScannerRunning = true;

    public static void main(String[] args) {
        final EchoClient client = new EchoClient();
        client.start();
    }

    private void start() {
        try {
            openConnection();
            final Scanner scanner = new Scanner(System.in);
            while (true) {
                final String msg = scanner.nextLine();
                if ("/q".equalsIgnoreCase(msg) || msg.isEmpty()) {
                    out.writeUTF("/q");
                    break;
                } else {
                    out.writeUTF(msg);
                }
            }
            isScannerRunning = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Соединение завершено");
    }

    private void closeConnection() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("localhost", 9000);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        final Thread thread = new Thread(() -> {
            try {
                while (true) {
                    final String message = in.readUTF();
                    if ("/q".equalsIgnoreCase(message)) {
                        if (isScannerRunning) System.out.println("Сервер инициировал завершение сеанса");
                        out.writeUTF("/q");
                        break;
                    }
                    System.out.println("Сообщение от сервера: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
            System.exit(0);
        });
        thread.start();
    }
}
