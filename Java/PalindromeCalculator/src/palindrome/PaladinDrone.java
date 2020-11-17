package palindrome;

public class PaladinDrone {
	/*
	 * This piece of code finds the highest product from a multiple of two "n" digit numbers that equal a palindrome.
	 */

	public static void main(String[] args){
		String limitString = "1";
		String startString = "1";
		String reducerString ="0.";
	    int  input = 2;
	    double reducer;
	    long start = 0, limit, x, y, z, out = 0;
	    boolean pal = false;
	    
	    //Create the number based on input (this will allow for the testing of different digit sizes)
	    for(int i=0; i < input; i++){
	    	limitString += "0";
	    	startString += "0";
	    	
	    	if(i+1 > 2 && (i+1)%2 == 0) {//Increases the reducer based on the amount of digits, at a rate of 1 every 2 digits over 2
	    	reducerString += "0";
	    	}
	    }
	    reducerString += "1";
	    
	    //Convert it to appropriate types
	    reducer = Double.parseDouble(reducerString);
	    limit = Long.parseLong(limitString);
	    start = Long.parseLong(startString);
	    
	    //Make start odd & reduce
	    start = 1+(start - (long) (start*reducer));
	        
	    x = start;
	    y = start;
	    z = 0;
	    
	    while(x < limit) {
	    	pal = false;
	    	y = start;
	    	
	    	while(y < limit) {
				if(x>y) {
					z = x*y;
				}
	    		if(z%11 == 0) {
	    			pal = palChecker(z);
	    			if(pal == true) {
	    				out = z;
	    			}
	    		}
	    		y+=2;
	    	}
			x+=2;
	    }
	    
	    System.out.println("Highest product: " + out);
	    System.exit(0);
	}
	
	//Checks that num & reverse num are the same
	public static boolean palChecker(long num) {
		long reverse=0,sum=0,temp;
		boolean palindrome = false;
  
        temp=num;    
        while(num>0){    
        reverse=num%10; 
        sum=(sum*10)+reverse;    
        num=num/10;    
        }   
        
        if(temp==sum){
        palindrome = true;
        }else{    
        palindrome = false;
        }
		return palindrome;
	}
}