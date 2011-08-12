public class CoinSolver {
    private static final int solveCoins(final int idx, final int[] values, final int target, final int acc) {
        if (target == 0) return acc + 1;
        if (idx == values.length) return acc;
        int val = (values[idx] <= target) ?
            solveCoins(idx, values,target-values[idx],acc) : 0;
        return val + solveCoins(idx+1, values,target,acc);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: CoinSolver coin1,[coin2,...,coinn] target");
        }
        String[] coinStrings = args[0].split(",");
        int[] coinValues = new int[coinStrings.length];
        int i = 0;
        for (String str : coinStrings) {
            coinValues[i++] = Integer.valueOf(str);
        }
        int target = Integer.valueOf(args[1]);
        System.out.println(solveCoins(0,coinValues,target,0));
    }

}
