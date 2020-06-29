public class RunTraffic20 {

    public static final int NUMCAR = 3;

    public static void main (String args[]) {

            int value = 0;

            Car[] car = new Car[NUMCAR];



            Freeway  freeway = new Freeway ();



            for (int i = 0; i < NUMCAR; i++)

                    car[i] = new Car (i, freeway);



            for (int i = 0; i < NUMCAR; i++)

                    car[i].start();



            try {

                    for (int i = 0; i < NUMCAR; i++)

                            car[i].join();

            }

            catch (InterruptedException e) {};



    }

} // RunTraffic20



class Freeway {

    private boolean[] merged;



    public Freeway () {

            merged = new boolean[RunTraffic20.NUMCAR];

            for (int i = 0; i < merged.length; i++)

                    merged[i] =false;

    }



    public synchronized void merge (int i) {

            merged[i] = true;

    }



    public synchronized boolean allMerged () {

            for (int i = 0; i < merged.length; i++)

                    if (!merged[i])

                            return false;

            return true;

    }



public synchronized boolean waitInTraffic (int id) {

            boolean furtherDelay = false;



            while ( !allMerged () ) {

                    try {

                            wait();

                    }

                    catch (InterruptedException e) {}

            }

            notifyAll ();

            if ( id%2 == 1 )

                    furtherDelay = true;

            return (furtherDelay);

    }

} // Freeway





class Car extends Thread {

    private int id;

    private int delay;

    private Freeway freeway;



    public Car ( int i, Freeway f ) {

            id = i;

            freeway = f;

            delay = 8*id;

    }



    public void run () {

            freeway.merge(id);

            delay = 2 * id * id - 4 * id + 8;

            boolean moreDelay = freeway.waitInTraffic (id);

            if (moreDelay)

                    delay += 32;

            System.out.println ("For Car " + id + ",delay = " + delay);

    }

} // Car
