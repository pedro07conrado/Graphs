package Order_Topologica; 

public class Order {
    public static void main(String[] args){
        int[] vector = new int[10];
        vector[0] = 2; 
        vector[1] = 10; 
        vector[2] = 9; 
        vector[3] = 2; 
        vector[4] = 5;
        vector[5] = 5;
        vector[6] = 5;
        vector[7] = 5;
        vector[8] = 5;
        vector[9] = 5;
        
        for(int i = 0; i < 10; i++ ){
            System.out.println(vector[i]);
        }
    }
}
