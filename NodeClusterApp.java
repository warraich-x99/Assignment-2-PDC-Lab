public class NodeClusterApp {
    public static void main(String[] args) {
        System.out.println("=== Distributed Ledger Node Cluster & Consensus Simulator ===");

        String genesisHash = "0000000000000000";
        TransactionBlock block1 = new TransactionBlock(1, "Transfer 50 BTC to Node A", genesisHash);
        TransactionBlock block2 = new TransactionBlock(2, "Execute Smart Contract #99", block1.getCurrentHash());

        System.out.println("[NODE-01] Validating Block 1 Hash: " + block1.getCurrentHash() + " -> Status: " + (block1.validateBlock() ? "VERIFIED" : "CORRUPTED"));
        System.out.println("[NODE-02] Validating Block 2 Hash: " + block2.getCurrentHash() + " -> Status: " + (block2.validateBlock() ? "VERIFIED" : "CORRUPTED"));
        System.out.println("[CONSENSUS] Distributed Ledger Node Cluster synchronized successfully.");
    }
}// JavaDoc update
