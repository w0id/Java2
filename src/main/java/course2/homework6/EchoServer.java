package course2.homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private DataInputStream in;
    private DataOutputStream out;
    final Scanner scanner = new Scanner(System.in);
    private boolean isScannerRunning = true;

    public static void main(String[] args) {
        final EchoServer server = new EchoServer();
        server.start();
    }

    private void start() {
        try {
            openConnection();
            while (true) {
                String msg = scanner.nextLine();
                if ("/q".equalsIgnoreCase(msg) || msg.isEmpty()) {
                    out.writeUTF("/q");
                    break;
                } else {
                    out.writeUTF(msg);
                }
            }
            isScannerRunning = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
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

    private void openConnection() {
        try(ServerSocket serverSocket = new ServerSocket(9000)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            Socket socket = serverSocket.accept();
            System.out.println("Клииент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            final Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        final String message = in.readUTF();
                        if ("/q".equalsIgnoreCase(message)) {
                            if (isScannerRunning) System.out.println("Клиент инициировал завершение сеанса");
                            out.writeUTF("/q");
                            break;
                        }
                        System.out.println("Сообщение от клиента: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                    System.out.println("Сервер остановлен");
                }
                System.exit(0);
            });
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
