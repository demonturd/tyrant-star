/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyrantstarringsimulator;

import java.util.Scanner;

/**
 *
 * @author Nate
 */
public class TyrantStarringSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int startStar;
        int endStar;
        int boomCount = 0;
        int trials = 0;
        int aggregateTrials = 0, aggregateBooms = 0;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the star you want to start at: ");
        startStar = scan.nextInt();
        int startStarOriginal = startStar;
        
        System.out.println("Please enter the star you want to end at: ");
        endStar = scan.nextInt();
        
        System.out.println("Please enter the number of simulations to run: ");
        int simulations = scan.nextInt();
                
        for (int i = 0; i < simulations; i++) {
            while (startStar != endStar) {            
                int result = StarTyrant(startStar);
                if ((startStar - result) > 2 )
                    boomCount++;            
                startStar = result;
                trials++;                            
            }
        
            long totalMesos = (long) trials*55832200;
            String totalMesosAsString = String.format("%,d", totalMesos); 
            
            if (simulations <= 5)
                System.out.println("Trial " + (i+1) + ": To get from " + startStarOriginal + " stars to "
                    + endStar + " stars took " + trials + " attempts with "
                    + boomCount + " booms. This process took " + totalMesosAsString + 
                    " mesos.");       
            
            aggregateTrials += trials;
            aggregateBooms += boomCount;
            boomCount = 0;
            trials = 0;
            startStar = startStarOriginal;
        }
        double averageTrials = (double) aggregateTrials / simulations;
        double averageBooms = (double) aggregateBooms / simulations;
        long averageMesos = (long) averageTrials*55832200;
            String averageMesosAsString = String.format("%,d", averageMesos);
        
        
        System.out.println("Average: To get from " + startStarOriginal + " stars to "
                + endStar + " stars took an average of " + averageTrials + " attempts with "
                + averageBooms + " booms. This process took " + averageMesosAsString + 
                " mesos on average.");
        
        System.out.println("Note: This simple simulator was compiled with data "
                + "from https://forum.nexoneu.com/showthread.php?1473734-Starforce-rates");
    }
        
    public static int StarTyrant(int startStar) {
        int chance = (int) ((Math.random()*1000)+ 1);        
        int endStar = 0;
        
        switch (startStar) {
            case 0:
                if (chance <= 500)
                    endStar = ++startStar;
                else
                    endStar = 0;
                break;
            case 1:                
                if (chance <= 500)
                    endStar = ++startStar;
                else
                    endStar = --startStar;
                break;
            case 2:
                if (chance <= 450)
                    endStar = ++startStar;
                else
                    endStar = --startStar;
                break;
            case 3:
                if (chance <= 400)
                    endStar = ++startStar;
                else
                    endStar = --startStar;
                break;
            case 4:
                if (chance <= 400)
                    endStar = ++startStar;
                else
                    endStar = --startStar;
                break;
            case 5:
                if (chance <= 400)
                    endStar = ++startStar;
                else if (chance > 400 && chance <= 982)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 6:
                if (chance <= 400)
                    endStar = ++startStar;
                else if (chance > 400 && chance <= 970)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 7:
                if (chance <= 400)
                    endStar = ++startStar;
                else if (chance > 400 && chance <= 958)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 8:
                if (chance <= 400)
                    endStar = ++startStar;
                else if (chance > 400 && chance <= 940)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 9:
                if (chance <= 370)
                    endStar = ++startStar;
                else if (chance > 370 && chance <= 905)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 10:
                if (chance <= 350)
                    endStar = ++startStar;
                else if (chance > 350 && chance <= 870)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 11:
                if (chance <= 350)
                    endStar = ++startStar;
                else if (chance > 400 && chance <= 837)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 12:
                if (chance <= 30)
                    endStar = ++startStar;
                else if (chance > 30 && chance <= 515)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 13:
                if (chance <= 20)
                    endStar = ++startStar;
                else if (chance > 20 && chance <= 510)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            case 14:
                if (chance <= 10)
                    endStar = ++startStar;
                else if (chance > 10 && chance <= 505)
                    endStar = --startStar;
                else
                    endStar = 0;
                break;
            default:
                break;
        }
        return endStar;
    }
    

}

