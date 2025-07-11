import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PortScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 System.out.print("Enter target IP or domain: ");
        String host = scanner.nextLine();

    System.out.print("Enter start port: ");
        int startPort = scanner.nextInt();

    System.out.print("Enter end port: ");
        int endPort = scanner.nextInt();

        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            System.out.println("❌ Invalid host.");
            return;
        }

     System.out.println("🔍 Scanning " + inetAddress.getHostAddress() + " from port " + startPort + " to " + endPort);

     for (int port = startPort; port <= endPort; port++) {
         int finalPort = port;
            new Thread(() -> {
            try (Socket socket = new Socket()){
               socket.connect(new InetSocketAddress(inetAddress, finalPort), 1000);
               System.out.println("✅ Port " + finalPort + " is open");
                } catch (IOException e) {
                    System.out.println("❌ Port " + finalPort + " is closed");
                }
                // Port is closed
            }).start();
        }
    }
}
