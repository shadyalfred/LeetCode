public class Solution
{
        int r, c;
    int[][] memo;
    LinkedList<int> masks;

    public int MaxStudents(char[][] seats)
    {
        r = seats.Length;
        c = seats[0].Length;
        memo = new int[r][];

        for (int i = 0; i < memo.Length; i++)
        {
            memo[i] = new int[1 << c];
        }

        for (int i = 0; i < r; i++)
        {
            Array.Fill(memo[i], -1);
        }

        return GetMax(seats, 0, 0);
    }

    private int CountBits(int n)
    {
        int count = 0;
        while (n != 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    private int GetMax(char[][] seats, int curRow, int prevRowMask)
    {
        if (curRow == r)
        {
            return 0;
        }
        if (memo[curRow][prevRowMask] != -1)
        {
            return memo[curRow][prevRowMask];
        }
        masks = new LinkedList<int>(); // reset the masks list for backtrack
        Backtrack(seats[curRow], 0, prevRowMask, 0); // backtrack results store in masks list
        int res = 0;
        foreach (int m in masks)
        {
            res = Math.Max(res, CountBits(m) + GetMax(seats, curRow + 1, m));
        }
        memo[curRow][prevRowMask] = res;
        return res;
    }

    // this returns all combination of legal seat assignment for a given row based on prevous row's mask
    private void Backtrack(char[] seats, int cur, int prevRowMask, int curRowMask)
    {
        if (cur == c)
        {
            masks.AddLast(curRowMask);
            return;
        }
        // cur seat is not taken
        Backtrack(seats, cur + 1, prevRowMask, curRowMask);

        // cur seat is taken, check if left, upper left and upper right positions are empty
        if (seats[cur] != '#'
            && (cur == 0 || (((curRowMask & (1 << (cur - 1))) == 0) && (prevRowMask & (1 << (cur - 1))) == 0))
            && (cur == c - 1 || ((prevRowMask & (1 << (cur + 1))) == 0)))
        {
            curRowMask |= (1 << (cur));
            Backtrack(seats, cur + 1, prevRowMask, curRowMask);
            curRowMask ^= (1 << (cur));
        }
    }
}