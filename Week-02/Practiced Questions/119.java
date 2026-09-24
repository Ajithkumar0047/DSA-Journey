class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        int[][] a = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            a[i] = new int[i + 1];

            if (i == 0) {
                a[i][0] = 1;
            } 
            else if (i == 1) {
                a[i][0] = 1;
                a[i][1] = 1;
            } 
            else {
                a[i][0] = 1;
                a[i][i] = 1;

                for (int j = 1; j < a[i].length - 1; j++) {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < a[rowIndex].length; j++) {
            result.add(a[rowIndex][j]);
        }

        return result;
    }
}