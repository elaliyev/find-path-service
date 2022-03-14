# find-path-service

simple request 

{
  "vertices":4,
  "adjacencyList":[[1,2],[3],[0,1],[]],
  "fromPath":2,
  "toPath":3
}

Note:
   "adjacencyList":[[1,2],[3],[0,1],[]] - means we have 4 vertices numbered from 0 to 3.
 
   each index is an array. represent a direction (path).
   in our example
   [
   [1,2] -  there is a path from 0 to 1 and 2
   [3], -  there is a path from 1 to 3
   [0,1], - there is a path from 2 to 0 and 1
   []     - no path from 3
   ]
 
                 
 

 
   From 2 to 3 path we only have 2 paths
   2->1->3
   2->0->1->3
   
   
   How to run? 
 There were implementing tests for rest and for service layer
 
