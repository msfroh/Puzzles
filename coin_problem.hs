module Main(main) where
import System( getArgs )

coin_solver :: [Int] -> Int -> Int
coin_solver xs n = coin_solver_acc xs n 0
  where
      coin_solver_acc _ 0 acc = acc + 1
      coin_solver_acc [] _ acc = acc
      coin_solver_acc (x:xs) n acc =
          coin_solver_acc xs n acc +
          (if x <= n
              then (coin_solver_acc (x:xs) (n-x) acc)
          else 0)

main :: IO()
main = do
    args <- getArgs
    case args of
        (x:y:_) -> print $ coin_solver (read x) (read y)
        _ -> error $ "Wrong number of arguments"
