import java.io.IOException;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class PortScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 System.out.print("Enter target IP or domain: ");
        String host = scanner.nextLine();

    System.out.print("Enter start port: ");
        int startPort = scanner.nextInt();
