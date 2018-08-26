import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class UrlShortening
{
  public String encodeShortUrl(int id){
    String possibilities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  char[] map = possibilities.toCharArray();
    String shortURL = "";
    
    StringBuilder sb = new StringBuilder(shortURL);
    
    while(id > 0){
    sb.append(map[id%62]);
      id = id/62;
    }
    
   return sb.reverse().toString();
    
  }
  
  public int decodeShortURL(String shortURL){
  char[] str = shortURL.toCharArray();
    int id = 0;
    for(int i = 0; i< str.length ; i++){
      if(str[i] >= 'a' && str[i] <= 'z'){
      id = id * 62 + (str[i] - 'a');
      }
      if(str[i] >= 'A' && str[i] <= 'Z'){
      id = id * 62 + (str[i] - 'A') + 26;
      }
      if(str[i] >= '0' && str[i] <= '9'){
      id = id * 62 + (str[i] - '0') + 52;
      }
      
    }
    
    return id;
  }
  
  public static void main(String[] args)
  {
    int id = 12345;
    HelloWorld hw = new HelloWorld();
    System.out.println(hw.decodeShortURL(hw.encodeShortUrl(id)));
  }
}
