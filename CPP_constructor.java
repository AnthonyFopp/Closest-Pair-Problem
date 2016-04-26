/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package closest.pair.problem.cpp;

import static java.lang.Math.*;

public class CPP_constructor {
    
    

    double minDistance = Integer.MAX_VALUE;
    double min_x1 = 0;
    double min_x2 = 0;
    double min_y1 = 0;
    double min_y2 = 0;
    double[][] input_array;
    double[][] unsortedYArray;
    double[][] unsortedXArray;
    
    
    
    public CPP_constructor(int coordinate_size, double[][] in_array){
        unsortedXArray = in_array;
        xSort(0, unsortedXArray.length - 1);
        input_array = unsortedXArray;
        printArray(input_array, "Starting Array Sorted by X values");
    }
    
    
    
    double closestPair(double[][] sArray){                                                  //closestPair() will return minimum distance of left and right sub arrays
        int median;
        double minLeft = 0;                                                                 //minLeft is minimum distance of left sub array
        double minRight = 0;                                                                //minRight is minimum distance of right sub array
        double minXCut = 0;                                                                 //minXCut is minimum distance of cutting line function
        double[][] sR;                                                                      //sR is right sub array
        double[][] sL;                                                                      //sL is left sub array
            if(sArray.length == 1){
                return Integer.MAX_VALUE;
            }
            else if(sArray.length == 2){                                                    //compare minDistance to new distance found
                if(findDistance(sArray[0], sArray[1]) < minDistance){                       //if new distance is less than old minDistance, swap
                    minDistance = findDistance(sArray[0], sArray[1]);                       //NEED WAY TO KEEP TRACK OF MINIMUM DISTANCE POINTS
                    min_x1 = sArray[0][0];
                    min_x2 = sArray[1][0];
                    min_y1 = sArray[0][1];
                    min_y2 = sArray[1][1];
                    System.out.println("Found new minimum distance of: " + minDistance + " at {" + min_x1 + "," + min_y1 + "} and {" + min_x2 + "," + min_y2 + "}");
                    System.out.println();
                }
                return minDistance;
            }
            else{
                median = (sArray.length)/2;                                                  //sArray.length/2 - 1 may be better
                System.out.println("Dividing at point: {" + sArray[median][0] + "," + sArray[median][1] + "} Between points: {" + sArray[0][0] + "," + sArray[0][1] + "} and {" + 
                            sArray[sArray.length - 1][0] + "," + sArray[sArray.length - 1][1] + "}");
                if(sArray.length%2 == 0){                                                   //if array is even
                    sL = new double[median][2];
                    sR = new double[median][2];
                    System.arraycopy(sArray, 0, sL, 0, median);                    //arraycopy() java documentation === https://docs.oracle.com/javase/7/docs/api/java/lang/System.html
                    System.arraycopy(sArray, median, sR, 0, median);
                }
                else{
                    sL = new double[median][2];  
                    sR = new double[median+1][2];
                    System.arraycopy(sArray, 0, sL, 0, median);
                    System.arraycopy(sArray, median, sR, 0, (median+1));
                }
            }
            //printArray(sArray, "main");
            //printArray(sL, "left");
            //printArray(sR, "right");
            minLeft = closestPair(sL);
            minRight = closestPair(sR);
            double cutline = sR[0][0];
            System.out.println("Performing X-Cut method at cutline: " + cutline);
            minXCut = closestPairXCut(cutline, minDistance, sL, sR);
        return minDistance;
    }
    
    double closestPairXCut(double cutLine, double min, double[][] lArray, double[][] rArray){                     //closestPairXCut will return closest distance of combined sub arrays
        double minCutDistance = Integer.MAX_VALUE;
        int count = 0;
        
        /////////////////////////////////////////////////////left span///////////////////////////////////////////////////////////////////////////////
        
        while(lArray.length - 1 - count >= 0 && cutLine - lArray[lArray.length - 1 - count][0] < minDistance){
            count++;
        }
        double[][] leftSpan = new double[count][2];
        for(int i = 0; i < count; i++){
            leftSpan[i][0] = lArray[lArray.length - 1 - i][0];
            leftSpan[i][1] = lArray[lArray.length - 1 - i][1];
        }
        //printArray(leftSpan, "leftSpan");
        count = 0;
        
        /////////////////////////////////////////////////////right span///////////////////////////////////////////////////////////////////////////////     
        
        while(count <= rArray.length - 1 && rArray[count][0] - cutLine < minDistance){
            count++;
        }
        double[][] rightSpan = new double[count][2];
        for(int i = 0; i < count; i++){
            rightSpan[i][0] = rArray[i][0];
            rightSpan[i][1] = rArray[i][1];
        }
        //printArray(rightSpan, "rightSpan");
        
        ////////////////////////////////////////////////////sort right span///////////////////////////////////////////////////////////////////////////        
        
        unsortedYArray = rightSpan;
        ySort(0,unsortedYArray.length - 1);
        rightSpan = unsortedYArray;
        
        for(int i = 0; i < leftSpan.length; i++){
            for(int j = 0; j < rightSpan.length; j++){
                if(findDistance(leftSpan[i],rightSpan[j]) < minDistance){
                    minDistance = findDistance(leftSpan[i],rightSpan[j]);
                    min_x1 = leftSpan[i][0];
                    min_x2 = rightSpan[j][0];
                    min_y1 = leftSpan[i][1];
                    min_y2 = rightSpan[j][1];
                    System.out.println("Found new minimum distance of: " + minDistance + " at {" + min_x1 + "," + min_y1 + "} and {" + min_x2 + "," + min_y2 + "}");
                    System.out.println();
                }
            }
        }
        
        return minCutDistance;
    }
    
    double findDistance(double[] p1, double[] p2){                                          // distance function.....not finished
        double distance = sqrt(pow(p1[0] - p2[0],2) + pow(p1[1] - p2[1],2));
        return distance;
    }
    
    void printArray(double[][] array, String name){
        for(int i = 0; i < array.length; i++){
            double xValue = array[i][0];
            double yValue = array[i][1];
            System.out.print("{" + xValue + "," + yValue + "}, ");
        }
        System.out.println(name);
    }
    
    void xSort(int lower, int higher){
        int i = lower;
        int j = higher;
        double pivot = unsortedXArray[i + (j - i)/2][0];
        while (i <= j){
            while(unsortedXArray[i][0] < pivot){
                i++;
            }
            while(unsortedXArray[j][0] > pivot){
                j--;
            }
                if(i <= j){
                    double temp = unsortedXArray[i][0];
                    unsortedXArray[i][0] = unsortedXArray[j][0];
                    unsortedXArray[j][0] = temp;
                    temp = unsortedXArray[i][1];
                    unsortedXArray[i][1] = unsortedXArray[j][1];
                    unsortedXArray[j][1] = temp;
                    i++;
                    j--;
                }
            if(lower < j){
                xSort(lower, j);
            }
            if(i < higher){
                xSort(i, higher);
            }
        }
    }
    
    void ySort(int lower, int higher){
        int i = lower;
        int j = higher;
        double pivot = unsortedYArray[i + (j - i)/2][1];
        while (i <= j){
            while(unsortedYArray[i][1] < pivot){
                i++;
            }
            while(unsortedYArray[j][1] > pivot){
                j--;
            }
                if(i <= j){
                    double temp = unsortedYArray[i][1];
                    unsortedYArray[i][1] = unsortedYArray[j][1];
                    unsortedYArray[j][1] = temp;
                    temp = unsortedYArray[i][0];
                    unsortedYArray[i][0] = unsortedYArray[j][0];
                    unsortedYArray[j][0] = temp;
                    i++;
                    j--;
                }
            if(lower < j){
                ySort(lower, j);
            }
            if(i < higher){
                ySort(i, higher);
            }
        }
    }
}
