public class TransactionBlock {
    private int blockId;
    private String data;
    private String previousHash;
    private String currentHash;

    public TransactionBlock(int blockId, String data, String previousHash) {
        this.blockId = blockId;
        this.data = data;
        this.previousHash = previousHash;
        this.currentHash = computeHash();
    }

    public String computeHash() {
        return Integer.toHexString((blockId + data + previousHash).hashCode());
    }

    public boolean validateBlock() {
        return currentHash.equals(computeHash());
    }

    public int getBlockId() { 
        return blockId; 
    }

    public String getCurrentHash() { 
        return currentHash; 
    }
}