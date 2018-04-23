public class StringManipulator {
    public String trimAndConcat(String str, String str1){
        return str.trim().concat(str1.trim());
    }
    public Integer getIndexOrNull(String word, char cha){
        Integer a = word.indexOf(cha);
        if(a <0){
            return null;
        }
        return a;
    }
    public Integer getIndexOrNull(String str, String str1){
        Integer a = str.indexOf(str1);
        if(a <0){
            return null;
        }
        return a;
    }
    public String concatSubstring(String str, int start, int end, String str1){
        return str.substring(start,end).concat(str1);
    }
}

