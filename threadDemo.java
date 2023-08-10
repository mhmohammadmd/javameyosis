class threadDemo extends Thread
{
public void run()
{
System.out.println("thread is executing");
System.out.println(currentThread());
}
public static void main(String[] args)
{
threadDemo td = new threadDemo();
System.out.println(currentThread());

threadDemo td1 = new threadDemo();
td.start();
System.out.println(currentThread());
td1.start();
System.out.println(currentThread().isAlive());
}
}

