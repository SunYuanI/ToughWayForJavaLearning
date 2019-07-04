package algorithm;

import java.util.Scanner;
import java.util.Stack;
public class StackTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack test=new Stack();
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		StringBuffer bf=new StringBuffer();
		for(int i=0;i<s.length();i++) {
			char temp=s.charAt(i);
			if(temp<='9'&&temp>='0') {
				bf.append(temp);
			}else {
				if(test.empty()) {
					test.push(temp);
				}else {
					if(temp=='+'||temp=='-'){
						char peek=(char) test.peek();
						while(peek=='*'||peek=='/'||peek=='+'||peek=='-') {
							bf.append(peek);
							test.pop();
							if(test.empty()) {
								break;
							}
							peek=(char) test.peek();
						}
						test.push(temp);
					}else {
						if(temp==')'){
							char peek=(char) test.peek();
							while(peek!='(') {
								bf.append(peek);
								test.pop();
								if(test.empty()) {
									break;
								}
								peek=(char) test.peek();
							}
							test.pop();
						}else {
							test.push(temp);
						}
					}
				}
			}
		}
		while(!test.empty()) {
			bf.append(test.peek());
			test.pop();
		}
		s=bf.toString();
		int result=0;
		for(int i=0;i<s.length();i++) {
			char temp=s.charAt(i);
			if(temp<='9'&&temp>='0') {
				test.push(Character.getNumericValue(temp));
			}else {
				int number1=(int) test.pop();
				int number2=(int) test.pop();
				if(temp=='+') {
					result=number1+number2;
				}
				if(temp=='-') {
					result=number1-number2;
				}
				if(temp=='*') {
					result=number1*number2;
				}
				if(temp=='/') {
					result=number1/number2;
				}
				test.push(result);
			}		
		}
		System.out.println(test.peek());
		in.close();
	}

}
