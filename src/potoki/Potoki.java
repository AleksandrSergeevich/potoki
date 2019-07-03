package potoki;


public class Potoki {

    public static void main(String[] args) {
        Potoki e1 = new Potoki();
        e1.method1();
        e1.method2();
    }

    public void method1 () {

        final int size = 10000000;
        float arr[] = new float[size];

        System.out.println("Create array1. Put 1 into each [i].");
        for(int i = 0; i<arr.length; i++) {
            arr[i]=1;
        }

        System.out.println("Make Math");
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<arr.length; i++) {
            arr[i]=(float)(arr[i] * Math.sin(0.2f+ i/5)* Math.cos(0.2f+ i/5) * Math.cos(0.4f + i/2));
        }
        long fintime = System.currentTimeMillis();

        long elapsedtime = fintime - startTime;
        System.out.println("Finish time: " + elapsedtime);

    }

    public void method2 () {

        final int size = 10000000;
        final int size2 = size /2;
        float arr[] = new float[size];
        float a1[] = new float[size2];
        float a2[] = new float[size2];

        System.out.println("Create array2. Put 1 into each [i].");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        System.out.println("Make 2 new arrays 'a1' , 'a2'.");
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr,0,a1,0,size2);
        System.arraycopy(arr,size2,a2,0, size2);

        try {
            System.out.println("Waiting for threads.");
            TheSecondThread mt1 = new TheSecondThread("Child #1", a1, "a1");
            TheSecondThread mt2 = new TheSecondThread("Child #2", a2, "a2");
            mt1.thread.join();
            mt2.thread.join();
        }
        catch (InterruptedException e) {
            System.out.println("Error");
        }

        System.out.println("Assamble arr");
        System.arraycopy(a1, 0, arr, 0, size2);
        System.arraycopy(a2, 0, arr, size2, size2);

        long fintime = System.currentTimeMillis();
        long elapsedtime = fintime - startTime;

        System.out.println("Finish time: " + elapsedtime);
    }
}

