package threads;

public class NewThread extends Thread{
     Resource res;
     NewThread(String name,  Resource res){
        super(name);
        this.res=res;
     }

    public void run(){
         while(res.writeIn(getName())){
             try {
                    sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
         }
    }
}
