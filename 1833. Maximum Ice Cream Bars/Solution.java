class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = costs[0];
        for (int i = 1; i < costs.length; i++) {
            if (max < costs[i]) {
                max = costs[i];
            }
        }

        int count[] = new int[max + 1];
        for (int i = 0; i < costs.length; i++) {
            count[costs[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                costs[j] = i;
                j++;
                count[i]--;
            }
        }

        int icr = 0;
        int i = 0;
        while (i < costs.length && costs[i] <= coins) {
            coins -= costs[i];
            icr++;
            i++;
        }
        return icr;
    }
}