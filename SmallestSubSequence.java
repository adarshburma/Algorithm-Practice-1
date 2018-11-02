import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Integer> needstofind = new TreeMap<String, Integer>();
        Map<String, Integer> hasfound = new TreeMap<String, Integer>();
        String final_result="";
        String result="";
        int begin=0;
        int end=0;
        String words[];
        String text_words[];
        String final_words[];
        String str_final;
        int begin_tmp=0;
        int end_tmp=0;
        int flag=0;
        int z=0;
        int len;
        int txt_len;
        int i;
        int count=0;
        int needstofind_size;
        int min=0;
        int final_length=0;
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        string = string.replaceAll("[^a-zA-Z| |]", " ");
        string = string.replaceAll("  ", " ");
        str_final=string;
        string=string.toLowerCase();
        z = in.nextInt();
        words = new String[z+1];
        in.nextLine();
        for(i=0; i<z; i++)
        {
            words[i] = in.nextLine();
            needstofind.put(words[i],1);
        }
        text_words = string.split(" ");
        final_words=str_final.split(" ");
        len=hasfound.size();
        txt_len=text_words.length;
        i=0;
        needstofind_size=needstofind.size();
        begin=0;
        count=0;
        for(end=0; end<txt_len; end++)
        {
            if(needstofind.containsKey(text_words[end])==false)continue;
            hasfound.put(text_words[end],hasfound.get(text_words[end])==null?1:hasfound.get(text_words[end])+1);
            if(hasfound.get(text_words[end])<=needstofind.get(text_words[end]) )count++;
            if(count==needstofind_size)
            {
                flag++;
                while(needstofind.get(text_words[begin])==null || hasfound.get(text_words[begin])>1)
                {
                    if(needstofind.containsKey(text_words[begin]))
                    {
                        if(hasfound.get(text_words[begin])>1)
                            hasfound.put(text_words[begin],hasfound.get(text_words[begin])-1);
                    }
                    begin++;

                }
                if(flag>1 && end-begin+1>min)continue;
                result="";
                min=end-begin+1;
                for(int j=begin; j<=end; j++)
                    result=result+final_words[j]+" ";
                if(flag==1)
                {
                    final_result=result;
                    final_length=min;
                }
                else if(min<final_length && flag>1)
                {
                    final_result=result;
                    final_length=min;
                }
            }
        }
        if(flag>0)System.out.println(""+final_result);
        else System.out.println("NO SUBSEGMENT FOUND");
    }
}
