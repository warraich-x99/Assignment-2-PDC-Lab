public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        String packetPayload = "RADAR";
        System.out.println("=== Zero-Trust Packet Symmetry Auditor ===");
        System.out.println("Ingested Raw Packet Payload: " + packetPayload);

        int len = packetPayload.length();
        TransactionStack stack = new TransactionStack(len);
        RequestQueue queue = new RequestQueue(len);

        // Ingest characters simultaneously into Stack (LIFO) and Queue (FIFO)
        for (int i = 0; i < len; i++) {
            char c = packetPayload.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        // Validate bi-directional symmetry (Palindrome Signature Match)
        boolean isPalindrome = true;
        for (int i = 0; i < len; i++) {
            char fromStack = stack.pop();
            char fromQueue = queue.dequeue();
            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("[VERIFIED] Packet payload exhibits bi-directional symmetry (Palindrome Signature Match).");
        } else {
            System.out.println("[SECURITY ALERT] Packet payload asymmetry detected!");
        }
    }
}