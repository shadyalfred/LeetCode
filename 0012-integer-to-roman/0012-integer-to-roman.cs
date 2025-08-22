public class Solution {
    public string IntToRoman(int num) {
        StringBuilder sb = new(4);

        List<int> digits = new List<int>(4);
        while (num > 0) {
            digits.Add(num % 10);
            num /= 10;
        }

        string n = num.ToString();
        for (int i = digits.Count - 1; i >= 0; i--) {
            int d = digits[i];
            int f = i + 1;
            if (f == 4) {
                while (d > 0) {
                    sb.Append('M');
                    d--;
                }
            } else if (f == 3) {
                if (d == 9) {
                    sb.Append("CM");
                    d = 0;
                } else if (d == 4) {
                    sb.Append("CD");
                    d = 0;
                } else if (d >= 5) {
                    sb.Append('D');
                    d -= 5;
                }

                while (d > 0) {
                    sb.Append('C');
                    d--;
                }
            } else if (f == 2) {
                if (d == 9) {
                    sb.Append("XC");
                    d = 0;
                } else if (d == 4) {
                    sb.Append("XL");
                    d = 0;
                } else if (d >= 5) {
                    sb.Append('L');
                    d -= 5;
                }

                while (d > 0) {
                    sb.Append('X');
                    d--;
                }
            } else {
                if (d == 9) {
                    sb.Append("IX");
                    d = 0;
                } else if (d == 4) {
                    sb.Append("IV");
                    d = 0;
                } else if (d >= 5) {
                    sb.Append('V');
                    d -= 5;
                }

                while (d > 0) {
                    sb.Append('I');
                    d--;
                }
            }
        }

        return sb.ToString();
    }
}