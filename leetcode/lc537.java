class Solution {
    public String complexNumberMultiply(String a, String b) {
    
    int cut1 = a.indexOf("+");
    int a1 = Integer.parseInt(a.substring(0, cut1));
    int a2 = Integer.parseInt(a.substring(cut1 + 1, a.length() - 1));
    
    int cut2= b.indexOf("+");
    int b1 = Integer.parseInt(b.substring(0, cut2));
    int b2 = Integer.parseInt(b.substring(cut2 + 1, b.length()-1));

    int p1 = a1 * b1 - a2 * b2;
    int p2 = a1 * b2 + b1 * a2;
    
    return p1 + "+" + p2 + "i";
    }
}
