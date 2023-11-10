package assn05;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test 1");
        testP1();
        System.out.println("Test 2");
        testP2();
        testP3();
        testP4();
        //quickTest();
    }

    // test Part 1
    public static void testP1(){
        /*
        Part 1 - Write some tests to convince yourself that your code for Part 1 is working
         */
        SimpleEmergencyRoom room = new SimpleEmergencyRoom();
        room.addPatient("Patient2", 2);
        room.addPatient("Patient1", 1);
        room.addPatient("Patient3", 3);
        System.out.println(room.dequeue().getValue());
        System.out.println(room.dequeue().getValue());
        System.out.println(room.dequeue().getValue());
    }

    // test Part 2
    public static void testP2(){
       /*
        Part 2 - Write some tests to convince yourself that your code for Part 2 is working
       */
        MaxBinHeapER heap = new MaxBinHeapER();
        heap.enqueue("Patient2", 2);
        heap.enqueue("Patient1", 1);
        heap.enqueue("Patient3", 3);
        heap.dequeue();
        heap.dequeue();
    }

    /*
    Part 3
     */
    public static void testP3(){
        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }
    }

    /*
    Part 4
     */
    public static void testP4() {
               /*
        Part 4 - Write some tests to convince yourself that your code for Part 4 is working
         */
        System.out.println("Starting task 4, printing nanoseconds:");
        double[] arr = compareRuntimes();
        for (double element : arr) {
            System.out.println(element);
        }
    }

    public static void quickTest(){

        MaxBinHeapER binHeap = new MaxBinHeapER();
        double elements = 1e7;
        for (double i = 0; i < elements; i++) binHeap.enqueue(i);

        // Code for (Task 4.2) Here
        double startingTime = System.nanoTime();

        while (binHeap.size() > 0){
            binHeap.dequeue();
        }

        double elapsedTime = System.nanoTime() - startingTime;
        System.out.println("Ten million elements in a heap :" + elapsedTime);
        System.out.println(elapsedTime/elements);

    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }
    
    public static double[] compareRuntimes() {
    	// Array which you will populate as part of Part 4
    	double[] results = new double[4];
    	
        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (Task 4.1) Here
        double startingTime = System.nanoTime();

        while (simplePQ.size() > 0){
            simplePQ.dequeue();
        }

        results[0] = System.nanoTime() - startingTime;
        results[1] = results[0]/100000;

        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        // Code for (Task 4.2) Here
        startingTime = System.nanoTime();

        while (binHeap.size() > 0){
            binHeap.dequeue();
        }

        results[2] = System.nanoTime() - startingTime;
        results[3] = results[2]/100000;

        return results;
    }

}