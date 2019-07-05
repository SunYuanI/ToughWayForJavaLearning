package algorithm;

public class JosephusProblem {
	private int M;
	private int N;
	private myqueue queue;
	private int arr[];
	public JosephusProblem(int N,int M) {
		this.M=M;
		this.N=N;
		queue=new myqueue(2*N);
		arr=new int[N-1];
	}
	public void separate() {
		for(int i=1;i<=N;i++) {
			queue.enqueue(i);
		}
		for(int j=0;j<arr.length;j++) {	
			for(int i=0;i<M;i++) {
				queue.enqueue(queue.dequeue());
			}
			arr[j]=queue.dequeue();
		}
	}
	public void show() {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a=System.currentTimeMillis();
		JosephusProblem test=new JosephusProblem(10000,4932);
		test.separate();
		test.show();
		long b=System.currentTimeMillis();
		System.out.println("-------------");
		System.out.println(b-a);
	}

}
class myqueue {
	private int arr[];
	private int front;
	private int back;
	private int currentSize;
	public myqueue(int limit) {
		arr=new int[limit];
		front=0;
		back=-1;
		currentSize=0;
	}
	public void enqueue(int number) {
		if(arr.length==++back) {
			back=0;
		}
		if(currentSize==arr.length) {
			System.out.println("out of bond");
			return;
		}
		arr[back]=number;
		currentSize++;
	}
	public int dequeue(){
		if(arr.length==++front) {
			front=0;
		}
		currentSize--;
		return arr[front];
	}
}