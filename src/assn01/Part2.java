package assn01;

public class Part2 {
    public static void main(String[] args){
        short sh = Short.MAX_VALUE;
        method2();
    }
    private static void method2() {
        int n2 = 0xABC;
        System.out.println(n2);
        method3();
    }
    private static void method3(){
        int[] a3 = {'a', 'z'};
        System.out.println(a3[0]+ " " + a3[1]);
    }
}
