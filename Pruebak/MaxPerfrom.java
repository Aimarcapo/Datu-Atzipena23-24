import java.util.ArrayList;
import java.util.List;

public class MaxPerfrom {
    public static void main(String[] args) {
        //consumeCPU();
        consumeMemory();
        /* List<byte[]> memoryHog = consumeMemory();
        //memoryHog.clear(); // Clean up memory
        System.gc(); */ // Suggest garbage collection
    }

    private static void consumeCPU() {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < numOfThreads; i++) {
            new Thread(() -> {
                while (true) {
                    // Infinite loop to keep CPU busy
                }
            }).start();
        }
    }

    private static void consumeMemory() {
        List<byte[]> memoryHog = new ArrayList<>();
        long maxMemory = Runtime.getRuntime().maxMemory();
    
        // Continuously allocate memory until system runs out of memory
        while (true) {
            // Allocate more memory in each iteration
            byte[] bytes = new byte[100 * 1024 * 1024 * 100]; // Allocate 100MB
            memoryHog.add(bytes);
    
            if (Runtime.getRuntime().freeMemory() < maxMemory * 0.95) {
                break;
            }
        }
    
    
    }
}
