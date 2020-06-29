
import java.util.Random;

class Player extends Thread {
    
    private Barrier go;
    
    private int playernum;
    
    private int selection;
    
    private Player Players[];
    
    private int Totalrounds; //player victory conditions
    
    private boolean win;
    
    private boolean draw;
    
    private boolean loss;
    
    private int rockWins = 0, paperWins = 0, scissorsWins = 0;
    
    public Player(Barrier B, int value, Player P[], int r)
    {
        go = B;
        playernum = value+1;
        Players = P;
        Totalrounds = r; 
    } //returns current player selection

    public int selection()
    { 
        return selection;
    } //returns total wins 

    public int rockWins()
    {
          return rockWins; 
    }
    
    public int paperWins()
    {
         return paperWins; 
    } 
    
    public int scissorsWins()
    {
         return scissorsWins; 
    }
    
    private void battle() 
    {
        int count = 0; 
        while(count < 2)
        {
         if(count+1 != playernum)
        {
             int nextplayer; 
             nextplayer = Players[count].selection();
            if(selection == 0)
            {
                 if(nextplayer == 0) 
                    draw = true;
                else if(nextplayer == 1) 
                    loss = true;
                else if(nextplayer == 2 && draw == false && loss == false) 
                    win = true; 
            }
            else if(selection == 1)
            {    
                if(nextplayer == 1) 
                    draw = true;
                else if(nextplayer == 2)
                     loss = true;
                else if(nextplayer == 0 && draw == false && loss == false) 
                     win = true; 
            }
            else if(selection == 2) 
            {
                 if(nextplayer == 2) 
                    draw = true;
                else if(nextplayer == 0) 
                    loss = true;
                else if(nextplayer == 1 && draw == false && loss == false) 
                    win = true;
            } 
        } 
    
        if(draw == true || loss == true) 
            win = false; 
            count++;
    }
    
    if (win)
    {
         if (selection == 0) 
            rockWins++;
        else if (selection == 1) 
            paperWins++; 
        else if (selection == 2) 
            scissorsWins++; }
    } 
    
    public void run() 
    {
    int round = 1; 
    while(round <= Totalrounds)
    {
         Random rand = new Random(); 
    
    selection = rand.nextInt(3);
    
    //rock = 0
    
    if(selection == 0) System.out.println ("Round " + round + ": Player " + playernum + " selects Rock");
    
    //paper = 1 
    else if(selection == 1)
    
    System.out.println ("Round " + round + ": Player " + playernum + " selects Paper");
    
    //scissors = 2 
    else if(selection == 2)
    
    System.out.println ("Round " + round + ": Player " + playernum + " selects Sicossors");
    
    go.waitForOthers();
    
    win = false;
    
    draw = false;
    
    loss = false; 
    
    battle();
    
    go.waitForOthers();
    
    if(win == true)
    
    System.out.println ("Round " + round +":" + " Player " + playernum + " wins!");
    
    else if(draw == true)
    
    System.out.println ("Round " + round +":" +" Player " + playernum + " Draws");
    
    else if(loss == true)
    
    System.out.println ("Round " + round +":" +" Player " + playernum +  " loses");
         round++; 
    } 
}
 }
    
    
    
    interface Barrier {
    
    public void waitForOthers();
    
    public void freeAll();
    
    }
    
    class Barrierimp implements Barrier {
    
    private int barriersize;
    
    private int waitingT;
    
    private int save;
    
    public Barrierimp(int thread)
     { 
        waitingT = 0;
        barriersize = thread;
         save = 0; 
    } 
    
    public synchronized void waitForOthers() 
    {
    
    waitingT++;
    
    if(waitingT < barriersize) 
    {
    
    try
    {
         wait();
    }
    
    catch (InterruptedException e) {}
    }
    
    else
    {
         waitingT = 0; 
         notifyAll();
    } 
    } //currently used for nothing 
    public void freeAll() 
    {
         waitingT = barriersize;
    }

    }

public class project
{ 
    public static final int rounds = 1000;

    public static void main (String[] args) 
    {
    
    Barrier go = new Barrierimp(2);
    
    Player[] p;
     p = new Player[2]; 
     Thread Players[] = new Thread[2];
    
    int rockWins = 0, paperWins = 0, scissorsWins = 0;
    
        p[0] = new Player(go, 0, p, rounds);
        p[1] = new Player(go, 1, p, rounds);

        Players[0] = new Thread(p[0]);
        Players[1] = new Thread(p[1]);

        Players[0].start(); 
        Players[1].start(); 
    
    
    for(int j = 0; j < 2; j++) 
    { 
        try 
        { 
            Players[j].join();
        }
        catch (InterruptedException e)
        {}; 
    }
    
    for(int j = 0; j < 2; j++) 
    {
         scissorsWins += p[j].scissorsWins();
         paperWins += p[j].paperWins();
          rockWins += p[j].rockWins();
    }
    
    System.out.println("Summary Statistics:");
    
    System.out.println("Number of times scissors won: " + scissorsWins);
    
    System.out.println("Number of times rock won: " + rockWins);
    
    System.out.println("Number of times paper won: " + paperWins);
    
    System.out.println("Number of draws: " + (rounds - (scissorsWins + rockWins + paperWins)));     
    } 
}

    
    