package LTC;

public class Wildcard_Matching_LeetCode_Java {
	
	public static void main(String[] args) {
		Wildcard_Matching_LeetCode_Java object = new Wildcard_Matching_LeetCode_Java();
        object.run();

    }
	
	void run() {
        //  isMatch(String s, String p)

        String s = "aaaa";
        String p = "***a";



        System.out.println(isMatch(s,p));
    }

 


    public boolean isMatch(String s, String p) {

        if((p.length()<1 ^ s.length()<1) && !p.equals("*"))
            return false;
        if(p.equals("*"))
            return true;


        boolean [][] result = new boolean [s.length()+1][p.length()+1];
        result[0][0]=true;
        int count=0;
        while(count<p.length() && p.charAt(count)=='*'){
            result[0][++count]=true;
        }

        for(int i=1; i<result.length; i++){
            for(int j=1; j<result[0].length; j++){
                if(p.charAt(j-1)!=s.charAt(i-1)){
                    if(p.charAt(j-1)=='?'){
                            result[i][j]=result[i-1][j-1];// else result[i][j]=false
                    }else if(p.charAt(j-1)=='*'){
                       // if(result[i-1][j] || result[i][j-1])
                            result[i][j]=result[i-1][j] || result[i][j-1]; // else result[i][j]=false
                    } // else result[i][j]=false
                } else{
                        result[i][j]=result[i-1][j-1];
                }


            }
        }

        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

        return result[result.length-1][result[0].length-1];
    }

}



