package potoki;

class TheSecondThread extends Thread {
    Thread thread;
    float arr[];
    String numarr;

    TheSecondThread(String name, float[] arr, String numarr) {
        thread = new Thread(this, name);
        this.arr = arr;
        this.numarr = numarr;
        thread.start();
    }

    public void run() {
        System.out.println(thread.getName() + " is started.");
        if(numarr == "a1") {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }else if (numarr == "a2") {
            for(int i = 0 , j = 5000000; i<arr.length; i++ ,j++) {
                arr[i]=(float)(arr[i] * Math.sin(0.2f+ j/5)* Math.cos(0.2f+ j/5) * Math.cos(0.4f + j/2));
            }
        }
        System.out.println(thread.getName() + " is complete.");
    }
}