public class Solution {
    public String intToRoman(int num) {
        if(num < 1 || num > 3999) {
            return "";
        }
        
        // get every digit 
        int digit = 1000;
        int[] digits = new int[4];
        
        for(int i = 0; i < digits.length; i++) {
            digits[i] = num / digit;
            num %= digit;
            digit /= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append( convert(digits[0], 'M',' ',' ') );
        sb.append( convert(digits[1], 'C','D','M'));
        sb.append( convert(digits[2], 'X','L','C'));
        sb.append( convert(digits[3], 'I','V','X'));
        
        return sb.toString();
    }
    
    public String convert(int digit, char one, char five, char ten) {
        StringBuilder sb = new StringBuilder();
        switch(digit) {
            case 9:
                sb.append(one);
                sb.append(ten);
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                sb.append(five);
                for(int i = 5; i < digit; i++) {
                    sb.append(one);
                }
                break;
            case 4:
                sb.append(one);
                sb.append(five);
                break;
            case 3:
            case 2:
            case 1:
                for(int i = 1; i <= digit; i++) {
                    sb.append(one);
                }
                break;
            default:
                break;
        }
        
        return sb.toString();
        
    }
}