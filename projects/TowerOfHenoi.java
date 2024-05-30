import java.util.Scanner;
public class TowerOfHenoi {
   
    static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
        if (disks == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        towerOfHanoi(disks - 1, source, destination, auxiliary);
      
        System.out.println("Move disk " + disks + " from " + source + " to " + destination);
       
        towerOfHanoi(disks - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("enter the number of disk");
        int disks = input.nextInt(); 
        System.out.println("Steps to solve Tower of Hanoi with " + disks + " disks:");
        towerOfHanoi(disks, 'A', 'B', 'C');
    }
}

