## Algorithms: Design and Analysis Part I - Stanford
Programming #3
* Compute a minimum cut of the graph G
    * Karger's Min cut randomized algorithm: Randomly contract edges until left with a pair of nodes

#### The algorithm
```
Foreach node v
   Keep track of S(v) contracted into v
   S(v) <- {v}
If G has only two nodes, v_1 and v_2, remaining
   Return cut (S(v_1), S(v_2))
Else
   e <- choose edge (u,v) uniformly at random
   G' <- G after contracting e
   x <- replace u and v
   S(x) <- S(u) U S(v)
   Recursively contract G'
```
