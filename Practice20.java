package codinginterview;

public class Practice20 {
    private int index = 0;

    private boolean isNumeric(char[] str) {
        if(str == null)
            return false;
        boolean numeric = scanInteger(str);
        if (index<str.length && str[index]=='.'){
            ++index;
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if (index<str.length && (str[index]=='e' || str[index]=='E')){
            ++index;
            numeric = numeric && scanInteger(str);
        }
        return numeric && (index == str.length);
    }

    /**
     * 扫描无符号整数
     * @param str 需要扫描的字符数组
     * @return bool
     */
    private boolean scanUnsignedInteger(char[] str){
        int before = index;
        while (index<str.length && str[index]>='0' && str[index]<='9')
            ++index;

        return index>before;
    }

    /**
     * 扫描含有符号的整数
     * @param str 需要扫描的字符数组
     * @return bool
     */
    private boolean scanInteger(char[] str){
        if (index<str.length && (str[index]=='+' || str[index]=='-'))
            index++;
        return scanUnsignedInteger(str);
    }

    public static void main(String[] args) {
        Practice20 practice20 = new Practice20();
        String str1 = "+100";
        String str2 = "-123";
        String str3 = "-1E-16";
        System.out.println(practice20.isNumeric(str1.toCharArray()));
        System.out.println(practice20.isNumeric(str2.toCharArray()));
//        System.out.println(practice20.isNumeric(str3.toCharArray()));
    }
}
