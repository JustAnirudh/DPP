package com.anirudh.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paanir on 3/28/17.
 */
//IMP: DFS in a matrix!

/*
Black Shapes
Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.
 */
public class BlackShapes {
    private boolean discovered[][]; //explored
    private int di[] = new int[]{1, -1, 0, 0}; //neighbours: (1,0) (-1, 0) (0, 1) (0,-1)
    private int dj[] = new int[]{0, 0, 1, -1};//neighbours ^
    private List<String> A;
    private int nRows, nCols;

    private boolean isValid(int i, int j) {

        if (i < 0 || i >= nRows || j < 0 || j >= nCols) //are in the matrix
            return false;

        if (A.get(i).charAt(j) != 'X') //is X, word at i and char at j
            return false;

        return true;
    }

    private void dfs(int i, int j) {

        discovered[i][j] = true; //discovered explored in a new matrix! no need waste time and make an adjacency list!!
        //also, no need to turn it to black, etc. Discovered and Finished are the same state here (unexplored, discovered, finished)

        for (int k = 0; k < 4; k++) { //for each neighbour, (creating the neighbour coordinates)

            int ii = i + di[k];
            int jj = j + dj[k];

            //(ii, jj) is a neighbour
            if (isValid(ii, jj) && !discovered[ii][jj]) { //is valid and "white"/undiscovered
                dfs(ii, jj);
            }
        }
    }

    public int black(List<String> A) { //find number of connected components, by using dfs in a matrix (dfs covers whole of a disconnected graph)
        int nShapes;

        if (A == null)
            return 0;

        nRows = A.size();
        nCols = A.get(0).length();

        discovered = new boolean[nRows][nCols];
        nShapes = 0;
        this.A = A;

        for (int i = 0; i < nRows; i++) { //dfs helper function
            for (int j = 0; j < nCols; j++) {
                if (!discovered[i][j] && A.get(i).charAt(j) == 'X') { //if white, do dfs
                    dfs(i, j);
                    nShapes++; //number of trees
                }
            }
        }

        return nShapes;
    }

}
