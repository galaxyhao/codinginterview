package codinginterview;

public class Practice04 {
    private static String replaceSpace(StringBuffer str) {
        int count = 0;  //空格的数量
        for(int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                ++count;
            }
        }
        int x = str.length() - 1; //原字符串上的指针
        int y = x + 2*count; //新字符串上的指针

        str.setLength(y+1);

        while(x<y){
            if(str.charAt(x) == ' '){
                str.setCharAt(y--,'0');
                str.setCharAt(y--,'2');
                str.setCharAt(y--,'%');
            }else{
                str.setCharAt(y--,str.charAt(x));
            }
            --x;
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(str));
    }
}

