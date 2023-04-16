public class Main {
    public static void main(String[] args) {
        myArrayList<Integer> list = new myArrayList<>();
        list.add(10);
        list.add(20);
        list.add(50);
        list.add(19);
        for (var wow: list) {
            System.out.print(wow + " ");
        }
        System.out.println();
        System.out.println(list.get(3));
        list.remove(3);
        for (var wow: list) {
            System.out.print(wow + " ");
        }
//        System.out.println(list);
    }
}