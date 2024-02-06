package StringBuilderVsStringBuffer.defaultPacakge;

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");

	StringBuilder sharedResource =new StringBuilder();
	
	Thread th1=new Thread(() -> {
	    for(int i=0;i<1000;i++){
	        sharedResource.append("A");
	    }
	});
	
	Thread th2 = new Thread(() ->{
	    for(int i=0;i<1000;i++){
	        sharedResource.append("B");
	    }
	});
	long t=System.currentTimeMillis();
	System.out.println("Time before thread started :: "+t);
	th1.start();
	th2.start();
	
	try {
		th1.join();
		th2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	long t1=System.currentTimeMillis() - t;
	System.out.println("Total time of execution :: "+t1);
	System.out.println("StringBuffer sharedResource length"+sharedResource.toString().length());
	}
}
