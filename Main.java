package g2;

import java.util.*;
class Trie{
    Trie ch[];
    boolean ended;
    int wc;
    Trie(){
        ch=new Trie[26];
        ended=false;
        wc=0;
    }
}
class Main{
    public static void main(String[]args){
        System.out.println("1: Insert\n 2: Is word Exist\n 3: get all word with prefix ps\n 4: Get all words\n 5: Increase operations by x\n");
        Scanner sc=new Scanner(System.in);
       
        Trie r=new Trie();
        System.out.println("Enter num of operations\n");
        int n=sc.nextInt();
        while(n--!=0) {
        System.out.println("Enter operation to be Executed\n");
        int op=sc.nextInt();
        if(op==1)
        {
        	String s=sc.next();
        	insert(r,s);
        	System.out.println("Insert Successfull\n");

        }
        else if(op==2)
        {
        	String s=sc.next();
  
        	System.out.println(exist(r,s));
        }
         else if(op==3)
        {
        	 String s=sc.next();
        	 List<String>li=new ArrayList<>();
        	 prefix(r,li,s);
        	 System.out.println(li);
        	 
        	 
        }
         else if(op==4)
        {    List<String>li=new ArrayList<>();
        String te="";
        help(r,li,te);
        	 System.out.println(li);
            
        }
         else if(op==5)
        {

            int x=sc.nextInt();
            n=x+n;
    }
        }
        }
      static void insert(Trie r,String s){
Trie t= r;
for(char c:s.toCharArray()){
    int i=c-'a';
    if(t.ch[i]==null)
    t.ch[i]=new Trie();
    t=t.ch[i];
    t.wc++;
}
t.ended=true;
        }
      static  void help(Trie r,List<String> li,String te){
            if(r.ended)
            li.add(te);
            for(int i=0;i<26;i++){
                if(r.ch[i]!=null){
                    char c=(char)(i+'a');
                    help(r.ch[i],li,te+c);
                }
            }
        }
      static  boolean exist(Trie r,String s){
            Trie t=r;
            for(char c:s.toCharArray()){
    int i=c-'a';
    if(t.ch[i]==null)
    return false;
    t=t.ch[i];
        }
        return t.ended;

    }
        static void prefix(Trie r,List<String> li,String ps) {
        	Trie t=r;
        	for(char c:ps.toCharArray()) {
        		int i=c-'a';
        		if(t.ch[i]==null)
        			return;
        		t=t.ch[i];
        		
        	}
        	help(t,li,ps);
        }
}
