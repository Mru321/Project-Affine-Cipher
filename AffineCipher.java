import java.util.Scanner; 
 
public class AffineCipher { 
 	public static String encrypt(String plaintext, int k1, int k2) {  	 	
        char P[]= new char[26];  	 	
        char C[]=new char[26];  	 	
        int V[]= new int[26];  	 	
        int ascii=97;  	 	
        int ascii1=65; 
 	 	int ascii2=0; 
 	 	for (int i=0; i<26; i++) { 
 	 	 	P[i]=(char)ascii; 
 	 	 	C[i]=(char)ascii1;  	 	 	
            V[i]=ascii2; 
 	 	 	ascii++; ascii1++; ascii2++; 
 	 	 	 
 	 	} 
 	 	String done=""; 
 	 	int index=0; 
 	 	for(int i=0; i<plaintext.length(); i++) {  	 	 	
            char c= plaintext.charAt(i);  	 	 	
            if (Character.isLetter(c)) {  	 	 	 	
                for (int j=0; j<26; j++) { 
 	 	 	 	 	if (P[j]==c) {  	 	 	 	 	 	
                        index=j; 
 	 	 	 	    } 
 	 	 	    } 
 	 	 	    int e= (index*k1+k2)%26;  	 	 	    
                char enc=C[e];  	 	 	    
                done=done+enc; 
 	 	 	} 
 	 	 	else { 
 	 	 	 	done=done+" "; 
 	 	 	} 
 	 	} 
 	 	return done; 
 	 	 
 	} 
 	public static String decrypt(String ciphertext, int k1, int k2) {  	 	
        char P[]= new char[26];  	 	
        char C[]=new char[26];  	 	
        int V[]= new int[26];  	 	
        int ascii=97;  	 	
        int ascii1=65;  	 	
        int ascii2=0; 
 	 	for (int i=0; i<26; i++) { 
 	 	 	P[i]=(char)ascii; 
 	 	 	C[i]=(char)ascii1;  	 	 	
            V[i]=ascii2; 
 	 	 	ascii++; ascii1++; ascii2++; 
 	 	 	 
 	 	} 
 	 	String done=""; 
 	 	 
 	 	int index=0; 
 	 	for(int i=0; i<ciphertext.length(); i++) {  	 	 	
            char c= ciphertext.charAt(i);  	 	 	
            if(Character.isLetter(c)) {  	 	 	    
                for (int j=0; j<26; j++) {  	 	 	 	    
                    if (C[j]==c) {  	 	 	 	 	    
                        index=j; 
 	 	 	 	    } 
 	 	 	    } 
 	 	 	 
 	 	 	 
 	 	 	    int e1=0; 
 	 	 	    for (int x=1; x<26; x++) {  	 	 	 	    
                    if(((k1*x)+2)%26==index){ 
 	 	 	 	 	    e1=e1+x;  	 	 	 	 	   
                        break;  	 	 	 	    } 
 	 	 	 	 
 	 	 	    } 
 	 	 	    char enc=P[e1]; 
 	 	 	    done=done+enc; 
 	 	    } 
 	 	    else { 
 	 	    done=done+" ";  
 	        } 
 	 	} 
 	 	return done; 
 	} 
  	public static void main(String[] args) {
 	 	Scanner sc= new Scanner(System.in); 
 	 	 
 	 	System.out.println("Enter the message(Lowe Case only): "); 
 	 	String word= sc.nextLine();  
 	 	 
 	 	String en= encrypt(word, 7, 2); 
        System.out.println("Encrypted msg: ");
 	 	System.out.println(en); 
 	 	String de= decrypt(en, 7, 2); 
 	 	System.out.println("Decrypted msg: ");
 	 	System.out.println(de);
    }
} 

