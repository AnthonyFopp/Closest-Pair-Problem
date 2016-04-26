/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package closest.pair.problem.cpp;


public class ClosestPairProblemCPP {
    
    static double[][] test_array = {{30.0,2.0}, {25,7}, {3,5}, {4.0,13.0}, {17.0,7.0}, {2.0,7.0}};
    static double[][] input_points = {{2.0,7.0}, {4.0,13.0}, {5.0,8.0}, {10.0,5.0}, {14.0,9.0}, {15.0,5.}, {17.0,7.0}, {19.0,10.0}, {22.0,7.0},
    {25.0,10.0}, {29.0,14.0}, {30.0,2.0}};
    
   
    
    public static void main(String[] args) {
        CPP_constructor test = new CPP_constructor(input_points.length, input_points);
        double test_min = test.closestPair(test.input_array);
        System.out.println("Final minimum distance is = " + test_min);
        System.out.println("At points " + test.min_x1 + "," + test.min_y1 + " and " + test.min_x2 + "," + test.min_y2);
    }
}
