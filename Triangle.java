package chapter1;
import inf.v3d.obj.*;
import inf.v3d.view.Viewer;

//step1
public class Triangle {
	private double ax;
	private double ay;
	private double bx;
	private double by;
	private double cx;
	private double cy;
	
	public Triangle() {
	this.ax = 0.0;
	this.ay = 0.0;
	this.bx = 0.0;
	this.by = 1.0;
	this.cx = 1.0;
	this.cy = 0.0;
	}
	
	public Triangle(double ax, double ay, double bx, double by, double cx, double cy) {
	this.ax = ax;
	this.ay = ay;
	this.bx = bx;
	this.by = by;
	this.cx = cx;
	this.cy = cy;
	}

	//step2 in my case I create a method displaying attributes
	public void printAttribute() {
		System.out.println("Your attributes are");

		System.out.println(this.ax + " " +this.ay);
		System.out.println(this.bx + " " +this.by);
		System.out.println(this.cx + " " +this.cy);		
		
	}
	
	//step3 display triangle
	public void draw(Viewer v) {

		Line line1 = new Line(this.ax, this.ay,0,this.bx,this.by,0);
		Line line2 = new Line(this.bx, this.by,0,this.cx,this.cy,0);
		Line line3 = new Line(this.cx, this.cy,0,this.ax,this.ay,0);
		//Viewer z = new Viewer();
		v.addObject3D(line1);
		v.addObject3D(line2);
		v.addObject3D(line3);
		v.setVisible(true);
	}
	
	//step4 culculate area. in my case, I made Length method first, in order to make Area method simple
	
	public double Length(double _x1, double _x2, double _y1, double _y2) {
		double length = Math.sqrt((_x1 - _x2)*(_x1 - _x2) + (_y1 - _y2)*(_y1 - _y2));
		return length;
	}
	
	public double Area() {
		double length1 = this.Length(this.ax,this.bx,this.ay,this.by);
		double length2 = this.Length(this.ax,this.cx,this.ay,this.cy);
		double angle = this.Angleab();
		double area = (0.50)*(length1)*(length2)*Math.sin(angle); 
		return area;
	}
	//step5
	public boolean checkPoint(double dx, double dy) {
		double area = this.Area();
		//use vector
		//calculation below is a little difficult to explain. Please google it
		Triangle abd = new Triangle(this.ax,this.ay, this.bx, this.by, dx, dy);
		Triangle acd = new Triangle(this.ax,this.ay, this.cx, this.cy, dx, dy);
		double areaabd = abd.Area();
		double areaacd = acd.Area();
		
		
		double s = (area)*(areaabd);
		double t = (area)*(areaacd);
		 
		if((0<s)&&(s<1)&&(0<t)&&(t<1)&&(0<1-s-t)&&(1-s-t<1)){
		    return true; //Inside Triangle
		}else{
		    return false;
		}
		
		/*my original idea
		 * 1 separate triangle into many, enough tiny rectangle
		 * 2 do judge as we did in the rectangle part(with for loop)
		 * If i have time I'll try 
		 */
	}
	
	//step6
	public void drawCircle(Viewer v) {
		
		/*introduce center of circle
		 * 
		 * (x1-p)^2+(y1-q)^2=R^2　(1)
	     * (x2-p)^2+(y2-q)^2=R^2　(2)
	     * (x3-p)^2+(y3-q)^2=R^2　(3)
		 */
		double p = ((this.ay-this.cy)*(this.ay*this.ay -this.by*this.by +this.ax*this.ax -this.bx*this.bx)
				-(this.ay-this.by)*(this.ay*this.ay -this.cy*this.cy +this.ax*this.ax -this.cx*this.cx)) 
				/ (2*(this.ay-this.cy)*(this.ax-this.bx)-2*(this.ay-this.by)*(this.ax-this.cx));
	
		double q = ((this.ax-this.cx)*(this.ax*this.ax -this.bx*this.bx +this.ay*this.ay -this.by*this.by)
				-(this.ax-this.bx)*(this.ax*this.ax -this.cx*this.cx +this.ay*this.ay -this.cy*this.cy))
				/ (2*(this.ax-this.cx)*(this.ay-this.by)-2*(this.ax-this.bx)*(this.ay-this.cy));
		
		//get Radius
		double rad = this.Length(this.ax,p,this.ay,q);
		
		Circle circle = new Circle(rad);
		circle.setCenter(p, q, 0);
		circle.setRadius(rad);
	
		v.addObject3D(circle);
		v.setVisible(true);
		
	System.out.println(p);
	System.out.println(q);
	}
	
	
	//Step7
	public double Angleab() {
		double dotproduct = ((this.bx - this.ax)*(this.cx - this.ax) + (this.by - this.ay)*(this.cy - this.ay));
		double costheta = dotproduct/(this.Length(this.ax,this.bx,this.ay,this.by)*this.Length(this.ax,this.cx,this.ay,this.cy));
		double angle = Math.acos(costheta);
		return angle;
	}
	
}
	//Anglebc,ca should be implemented as above
	

	

		
		/*my original idea
		 * 1 separate triangle into many, enough tiny rectangle
		 * 2 do judge as we did in the rectangle part(with for loop)
		 * If i have time I'll try 
		 * 
		 * 	public boolean checkPoint(double dx, double dy) {
		double area = this.Area();
		//use vector
		//calculation below is a little difficult to explain. Please google it
		Triangle abd = new Triangle(this.ax,this.ay, this.bx, this.by, dx, dy);
		Triangle acd = new Triangle(this.ax,this.ay, this.cx, this.cy, dx, dy);
		double areaabd = abd.Area();
		double areaacd = acd.Area();
		
		
		double s = (area)*(areaabd);
		double t = (area)*(areaacd);
		 
		if((0<s)&&(s<1)&&(0<t)&&(t<1)&&(0<1-s-t)&&(1-s-t<1)){
		    return true; //Inside Triangle
		}else{
		    return false;
		}
		 * 
		 */

	


/*ignore below this part
 * 		for(int i = 0; i < 6; i++) {
			
		}
			public double Anglebc() {
		double dotproduct = (this.bx * this.cx + this.by * this.cy);
		double costheta = dotproduct/(this.Length(this.bx,this.cx,this.by,this.cy)*this.Length(this.cx,this.ax,this.cy,this.ay));
		double angle = Math.acos(costheta);
		return angle;
	}
	
	public double Angleca() {
		double dotproduct = (this.cx * this.ax + this.cy * this.ay);
		double costheta = dotproduct/(this.Length(this.cx,this.ax,this.cy,this.ay)*this.Length(this.ax,this.bx,this.ay,this.by));

		return Math.acos(costheta);//arccos. we didn't learn this method I guess..
	}
		
		
    //careful! don't type like (1/2) instead of (0.5). 
 */

