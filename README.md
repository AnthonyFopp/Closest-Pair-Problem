# Closest-Pair-Problem
Finds the closest pair of points in an array of points. 

Here is the psuedo code that I got from my homework correction

Sx: points sorted by x-coordinate; Sy: points sorted by y-coordinate;
Closest_Pari(S)

{
          if |S| = 1, return INF;
          if |S| = 2, return dis(p1,p2)
          m <- median (Sx)
          Divide S into S1, S2 at m
          dl <- Closet_Pair (S1)
          dr <- Closet_pair (S2)
          dc <- closet_Pair_XCut (m, S, min{dl, dr})
          return d <- min {dl, dr, dc}
}
Closet_Pair_XCut (m,s,d)
{ 
         for every point p in Sy
              if  |p.x-m|<d
                  put p into array Sc
         for every point pi in Sc such that pi.x<m
              d<- min {d, dis(pi-3,pi), dis(pi-2,pi), dis(pi-1,pi), dis(pi,pi+1), dis(pi,pi+2), dis(pi, pi+3)}
         return d
}
b. T(n)=2T(n/2)+n=4T(n/4)+2n=8(n/8)+3n
=2^iT(n/(2^i))+in =O(nlogn)

------------------------------------------------------------------------------------------------

We still have to figure out the combining section and we havn't written anything in the main function to debug. There is a section below the main function that will deal with filling and sorting the x and y arrays. 
