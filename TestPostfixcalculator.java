
public class TestPostfixcalculator {

		
		 public static void main(String [] args) {
		
		 PostfixCalculator calc = new PostfixCalculator();
		
		 calc.push(1);
		 calc.print();
		 calc.push(2);
		 calc.print();
		 calc.performOperation('+');
		 calc.print();
		 calc.push (4);
		 calc.print();
		 calc.performOperation('*');
		 calc.print();
		 calc.push (3);
		 calc.print();
		 calc.performOperation('+');
		 calc.print();
		 
		 
		 //below I calculated 4*(1+2+3) + 1 + 5*2(just for my own additional check)
		 //☝in reverse polish, it should be (1 2 + 3 + 4 * 1 + 2 5 *)
		 PostfixCalculator calc2 = new PostfixCalculator();
		 calc2.push(1);
		 calc2.print();
		 calc2.push(2);
		 calc2.print();
		 calc2.performOperation('+');
		 calc2.print();
		 calc2.push (3);
		 calc2.print();
		 calc2.performOperation('+');
		 calc2.print();
		 calc2.push (4);
		 calc2.print();
		 calc2.performOperation('*');
		 calc2.print();
		 calc2.push(1);
		 calc2.print();
		 calc2.performOperation('+');
		 calc2.push(2);
		 calc2.print();
		 calc2.print();
		 calc2.push (5);
		 calc2.print();
		 calc2.performOperation('*');
		 
		 System.out.println(calc2.getResult());
		 }
		 
}
