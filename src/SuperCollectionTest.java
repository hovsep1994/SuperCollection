public class SuperCollectionTest {

    public static void main(String[] args) {
        test1();
    }


    private static void test1() {
        SuperCollection<String> collection = new SuperCollection<>();
        collection.add("asd");
        collection.add("asd");
        collection.add("asd");
        int count = 0;
        for (String s : collection) {
            if (s.equals("asd")) {
                count += 1;
            }
        }
        if (count != 1) {
            throw new RuntimeException("Super collection is not unique");
        }
    }

}
