import java.util.Stack;

public class PostfixCalculator {
	private Stack <Double> numbers;
	
	public PostfixCalculator() {
		Stack post = new Stack();
		this.numbers = post;
	}

	public void push(double x){
		this.numbers.push(x);
	}

	public void performOperation(char type) {
		double num2 = 0;
		if(type == '+') {
			num2 += this.numbers.peek();
			numbers.pop();
			num2 += this.numbers.peek();
			numbers.pop();
			
			this.numbers.push(num2);
			num2 = 0;
		}
		else if(type == '*') {
			num2 += this.numbers.peek();
			numbers.pop();
			num2 = num2 * this.numbers.peek();
			numbers.pop();
			
			this.numbers.push(num2);
			num2 = 0;			
		}
		
	}
	public double getResult() {
		double sum = 0;
		for(int i = 0; i < this.numbers.size(); i++) {
			sum += this.numbers.get(i);
		}
		return sum;
	}
	public void print() {
		System.out.println(numbers);
	}
	
	
	
	
}
