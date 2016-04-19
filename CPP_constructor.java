/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package closest.pair.problem.cpp;

public class CPP_constructor {
    
    

    double minDistance = Integer.MAX_VALUE;
    double[][] testy;
    
    
    public CPP_constructor(int coordinate_size){
        testy = new double[coordinate_size][2];
    }
    
    double closestPair(double[][] sArray){                                                  //closestPair() will return minimum distance of left and right sub arrays
        int median = 0;
        double minLeft = 0;                                                                 //minLeft is minimum distance of left sub array
        double minRight = 0;                                                                //minRight is minimum distance of right sub array
        double minXCut = 0;                                                                 //minXCut is minimum distance of cutting line function
        double[][] sR;                                                                      //sR is right sub array
        double[][] sL;                                                                      //sL is left sub array
            if(sArray.length == 1){
                return -1;
            }
            else if(sArray.length == 2){                                                    //compare minDistance to new distance found
                if(findDistance(sArray[0], sArray[1]) < minDistance){                       //if new distance is less than old minDistance, swap
                    minDistance = findDistance(sArray[0], sArray[1]);                       //NEED WAY TO KEEP TRACK OF MINIMUM DISTANCE POINTS
                }
                return minDistance;
            }
            else{
                median = (sArray.length)/2;                                                  //sArray.length/2 - 1 may be better
                if(sArray.length%2 == 0){                                                   //if array is even
                    sL = new double[median][2];
                    sR = new double[median][2];
                    System.arraycopy(sArray, 0, sL, median - 1, median);                    //arraycopy() java documentation === https://docs.oracle.com/javase/7/docs/api/java/lang/System.html
                    System.arraycopy(sArray, median, sR, (sArray.length - 1), median);
                }
                else{
                    sL = new double[median][2];  
                    sR = new double[median+1][2];
                    System.arraycopy(sArray, 0, sL, median - 1, median);
                    System.arraycopy(sArray, median, sR, (sArray.length - 1), (median+1));
                }
            }
            minLeft = closestPair(sL);
            minRight = closestPair(sR);
            minXCut = closestPairXCut(median, minDistance, sArray);
        return minDistance;
    }
    
    double closestPairXCut(double cutLine, double min, double[][] sArray){                     //closestPairXCut will return closest distance of combined sub arrays
        int minCutDistance = 0;
        return minCutDistance;
    }
    
    double findDistance(double[] p1, double[] p2){                                          // distance function.....not finished
        double distance = 0;
        return distance;
    }
}
