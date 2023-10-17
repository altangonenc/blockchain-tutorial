import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockTest {

    @Test
    public void givenBlockchain_whenNewBlockAdded_thenSuccess() {
        List<Block> blockchain = new ArrayList<>();
        int prefix = 4;
        String prefixString = new String(new char[prefix]).replace('\0', '0');

        // Add an initial block to the blockchain
        Block genesisBlock = new Block("Genesis Block", "0", new Date().getTime());
        genesisBlock.mineBlock(prefix);
        blockchain.add(genesisBlock);

        Block newBlock = new Block(
                "This is a New Block.",
                blockchain.get(blockchain.size() - 1).getHash(),
                new Date().getTime());
        newBlock.mineBlock(prefix);
        assertTrue(newBlock.getHash().substring(0, prefix).equals(prefixString));
        blockchain.add(newBlock);
    }
}
