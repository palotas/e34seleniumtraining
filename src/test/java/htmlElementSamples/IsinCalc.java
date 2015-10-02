package htmlElementSamples;

/**
 * Created by gridfusion on 23/09/15.
 */
public class IsinCalc {

    public int calculateCheckISIN(String src)
    {
        int  result = 0;
        int  whatLength = (src.length() == 12)? 1 : 2;
        int  current;
        for(int i = src.length() - 1; i >= 0; i--)
        {
            current = src.charAt(i);
            if(current > '9')
            {
                // It is a char
                current -= ('A' - 10);
                result += (3-whatLength)*(current/10) + whatLength*current + (whatLength-1)*(current%10)/5;
            }
            else
            {
                // It is a numeric character
                current -= '0';
                result += whatLength*current + (whatLength-1)*(current/5);
                whatLength = 3 - whatLength;
            }
        }
        result %= 10;
        result = (10 - result%10) % 10;
        return result;
    }


}
