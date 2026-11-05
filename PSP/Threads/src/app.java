public class app {
    public static void main(String[] args) throws Exception {
       
        Miner m1 = new  Miner("Claudia");
        Miner m2 = new  Miner("Jose");
        long time1 = System.currentTimeMillis();
        m1.start();
        m2.start();
        m1.join();
        m2.join();
        long time2 = System.currentTimeMillis();
        long TimeTotal = time2 - time1;
        System.out.println("\n"+ TimeTotal + " ms");
    }
}
