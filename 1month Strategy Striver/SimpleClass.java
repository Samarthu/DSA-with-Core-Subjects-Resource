import java.util.*;

class tejas{
	int height;
	int weight;
	String nickname;
	tejas(int h,int w,String n){
		this.height = h;
		this.weight = w;
		this.nickname = n;
	}
	public void show()
	{
		System.out.println( height +" " + weight +" " +nickname);
	}
}
class SimpleClass{
	public static void main(String[] args) {
		tejas t = new tejas(5, 70, "teju");
		t.weight = 90;
		t.show();
	}
}