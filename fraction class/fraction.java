public class fraction {
 
    private int num;
    private int denom;
    
    public fraction () {
        num = 0;
        denom = 1;
    }
    
    public fraction (int n, int d) {
        num = n;
        setDenominator(d);
    }
    
    public fraction (String f) {
        int fwdIndex = f.indexOf("/");
        String numString = f.substring(0,fwdIndex);
        String denomString = f.substring(fwdIndex + 1);
        num = Integer.parseInt(numString);
        int d = Integer.parseInt(denomString);
        setDenominator(d);
    }
    
    public fraction (fraction f) {
        num = f.num;
        denom = f.denom;
    }
    
    public int getNumerator () {
        return num;
    }
    
    public int getDenominator () {
        return denom;
    }
    
    public void setNumerator (int n) {
        num = n;
    }
    
    public void setDenominator (int d) {
        if (d!= 0) {
            denom = d;
        } else {
            denom = 1;
            System.out.println("oopS");
        }         
    }
    
    public String toString () {
        return num + "/" + denom;
    }
    
    private int GCF (int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        if (a == 0 || b == 0) return 1;
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        
        return b;
    }
    
    public void reduce () {
        int gcf = GCF(num,denom);
        num = num / gcf;
        denom = denom / gcf;
        
    }
    
    public static fraction mult (fraction a, fraction b) {
        fraction answer = new fraction ();
        answer.setNumerator(a.num * b.num);
        answer.setDenominator(a.denom * b.denom);
        answer.reduce();           
        return answer;
    }
}