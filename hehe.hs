module Hehe where
f::[[Int]]
f=[[1,2,3],[2,1,3],[2,3,1],[1,2,3],[3,1,2],[3,2,3]] 
election::[[Int]]->[Int]->Int->(Int,[Int])
election f elist n
   | isend votes n      = (first,elist)
   | isequal (sumvotes votes 1 n) elist (length f)  (n- (length elist))   = (0,elist)
   | otherwise         = election votes (min:elist)  n
       where
         min= snd $ findmin (sumvotes f 1 n)
         first=snd (findmax (sumvotes votes 1 n ))
         votes = eliminate f elist
isequal::[(Int,Int)]->[Int]->Int->Int->Bool
isequal []  _ _ _ =True
isequal votes@((x,y):xs) elist  sum  count
  | ((x*count)==sum) || (elem x elist) = isequal xs elist sum count
  | otherwise                   =False
sumvotes::[[Int]]->Int->Int->[(Int,Int)]
sumvotes votes i n
    | n==0  = []
    | otherwise = ((sumiter votes i 0),i): (sumvotes votes (i+1) (n-1))
sumiter [] _ sum =sum
sumiter  votes  i sum
   | head (head votes) == i = sumiter (tail votes)  i (sum+1)
   | otherwise              = sumiter (tail votes)  i sum
eliminate votes  []   = votes
eliminate [] 	_   =  []
eliminate votes elist   = (filter (\x -> not(elem x elist)) (head votes)) : eliminate  (tail votes)  elist     
findmax xs= findmaxiter xs (0,0) 0
     where 
           findmaxiter::[(Int,Int)] -> (Int,Int)-> Int->(Int,Int)
           findmaxiter  [] index  _ = index
           findmaxiter  x  index  max  
		         |  (fst (head x))>max   = findmaxiter (tail x)  (head x)   (fst (head x))
                 |   otherwise           = findmaxiter  (tail x)  index   max    
findmin xs = findminiter xs (0,0) 10000 
     where 
           findminiter []   index  _  = index
           findminiter x  index min 
                |  (fst (head x))<min   = findminiter (tail x)  (head x)   (fst (head x))
                |   otherwise           = findminiter  (tail x)  index   min 
isend votes n
   | 2*(fst  (findmax  (sumvotes votes 1 n))) > ( sumv( (sumvotes votes 1 n))) = True
   |  otherwise                                                   =  False    
        where 
            sumv x=sumofvalues x 0 
            sumofvalues [] acc=acc
            sumofvalues  x  acc= sumofvalues (tail x) (acc+( fst (head x)))