public class ThreadMethos extends Thread
 {
    public void run()
 {
    for(int i=0;i<10;i++)
    {
    System.out.println("Executing Thread: "+getName());
    }
}
public static void main(String[] args)
{
    ThreadMethos t1=new ThreadMethos();
    t1.setPriority(1); //set the Priority of thread to 1
    System.out.println(t1.getPriority()); //returns 1
    ThreadMethos t2=new ThreadMethos();
    t2.setPriority(10); //set the Priority of thread to 10
    System.out.println(t2.getPriority()); //returns 10
//Priority is in range of 1-10 (0-lowest, 10-highest)
t1.start();
t2.start();
}

}
