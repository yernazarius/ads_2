public class Main {
    public static void main(String[] args) {
        myArrayList<Integer> arrayList = new myArrayList<>();
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(423);
        arrayList.add(11);
        arrayList.add(4);
        arrayList.add(511);
        for (int a: arrayList)
            System.out.print(a + " ");

        arrayList.remove(2);
        System.out.println();
        for (int a: arrayList)
            System.out.print(a + " ");
        System.out.println();

        arrayList.remove((Integer)12);
        for (int a: arrayList) System.out.print(a + " ");
        System.out.println();

        System.out.println("Size" + arrayList.size());
        System.out.println("Getting 3 element " + arrayList.get(2));
        System.out.println("any 423 in array? " + arrayList.contains(5));
        System.out.println("any 9999 in array? " + arrayList.contains(9));
        arrayList.add(1111,4);
        System.out.println("after inserting");
        for (int a: arrayList) System.out.print(a + " ");
        arrayList.sort();
        System.out.println("Sorted ArrayList: ");
        for (int a: arrayList) System.out.print(a + " ");

    }
}
