import java.io.*;

class Crc {

    static int[] divide(int[] data, int[] divisor) {
        int[] rem = data.clone();

        for (int i = 0; i <= data.length - divisor.length; i++) {
            if (rem[i] == 1) {
                for (int j = 0; j < divisor.length; j++) {
                    rem[i + j] ^= divisor[j];
                }
            }
        }
        return rem;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Enter number of data bits:");
        int dataBits = Integer.parseInt(br.readLine());

        if (dataBits < 1) {
            System.out.println("Invalid data length.");
            return;
        }

        int[] data = new int[dataBits];

        System.out.println("Enter data bits (0 or 1):");
        for (int i = 0; i < dataBits; i++) {
            data[i] = Integer.parseInt(br.readLine());

            if (data[i] != 0 && data[i] != 1) {
                System.out.println("Invalid binary bit.");
                return;
            }
        }

        System.out.println("Enter number of divisor bits:");
        int divisorBits = Integer.parseInt(br.readLine());

        if (divisorBits < 2) {
            System.out.println("Invalid divisor length.");
            return;
        }

        int[] divisor = new int[divisorBits];

        System.out.println("Enter divisor bits (0 or 1):");
        for (int i = 0; i < divisorBits; i++) {
            divisor[i] = Integer.parseInt(br.readLine());

            if (divisor[i] != 0 && divisor[i] != 1) {
                System.out.println("Invalid binary bit.");
                return;
            }
        }

        if (divisor[0] != 1 || divisorBits > dataBits + divisorBits - 1) {
            System.out.println("Invalid divisor.");
            return;
        }

        int totalLength = dataBits + divisorBits - 1;

        int[] div = new int[totalLength];

        for (int i = 0; i < dataBits; i++) {
            div[i] = data[i];
        }

        System.out.print("Data bits are: ");
        for (int bit : data) {
            System.out.print(bit);
        }

        System.out.print("\nDivisor bits are: ");
        for (int bit : divisor) {
            System.out.print(bit);
        }

        System.out.print("\nDividend after appending 0's: ");
        for (int bit : div) {
            System.out.print(bit);
        }

        // CRC Generation
        int[] rem = divide(div, divisor);
        int[] crc = div.clone();

        for (int i = 0; i < totalLength; i++) {
            crc[i] ^= rem[i];
        }

        System.out.print("\nCRC Code: ");
        for (int bit : crc) {
            System.out.print(bit);
        }

        // Error Detection
        System.out.println("\n\nEnter received CRC code of "
                + totalLength + " bits:");

        int[] received = new int[totalLength];

        for (int i = 0; i < totalLength; i++) {
            received[i] = Integer.parseInt(br.readLine());

            if (received[i] != 0 && received[i] != 1) {
                System.out.println("Invalid binary bit.");
                return;
            }
        }

        int[] checkRem = divide(received, divisor);

        boolean error = false;

        for (int bit : checkRem) {
            if (bit != 0) {
                error = true;
                break;
            }
        }

        if (error) {
            System.out.println("Error detected in received data.");
        } else {
            System.out.println("No Error detected.");
        }

        System.out.println("THANK YOU.... :)");
    }
}
