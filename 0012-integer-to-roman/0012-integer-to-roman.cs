public class Solution {
    public string IntToRoman(int num) {
        StringBuilder sb = new(4);

        string n = num.ToString();
        for (int i = 0; i < n.Length; i++) {
            int d = n[i] - '0';
            int f = n.Length - i;
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