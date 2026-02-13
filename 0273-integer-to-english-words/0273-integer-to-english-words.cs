public class Solution {
  public string NumberToWords(int num) {
    if (num == 0)
    {
      return "Zero";
    }

    var words = new List<string>(8);

    var parts = new List<byte[]>(8);

    var i = 2;
    var part = new byte[3];
    while (num > 0)
    {
      var n = num % 10;
      num /= 10;
      part[i] = (byte)n;
      i--;

      if (i == -1)
      {
        i = 2;
        parts.Add(part);
        part = new byte[3];
      }
    }

    if (i != 2)
    {
      parts.Add(part);
    }

    i = parts.Count - 1;

    for (; i >= 0; i--)
    {
      var p = parts[i];

      int j = 0;
      while (i == parts.Count - 1 && p[j] == 0)
      {
        j++;
      }

      for (; j < 3; j++)
      {
        if (j == 1)
        {
          if (p[j] == 1)
          {
            words.Add(
              (p[j] * 10 + p[j + 1]) switch
              {
                10 => "Ten",
                11 => "Eleven",
                12 => "Twelve",
                13 => "Thirteen",
                14 => "Fourteen",
                15 => "Fifteen",
                16 => "Sixteen",
                17 => "Seventeen",
                18 => "Eighteen",
                19 => "Nineteen",
                _ => ""
              }
            );
            j += 2;
          }
          else if (p[j] != 0)
          {
            words.Add(
              p[j] switch
              {
                2 => "Twenty",
                3 => "Thirty",
                4 => "Forty",
                5 => "Fifty",
                6 => "Sixty",
                7 => "Seventy",
                8 => "Eighty",
                9 => "Ninety",
                _ => ""
              }
            );
          }

          continue;
        }

        if (p[j] != 0)
        {
          words.Add(
            p[j] switch
            {
              1 => "One",
              2 => "Two",
              3 => "Three",
              4 => "Four",
              5 => "Five",
              6 => "Six",
              7 => "Seven",
              8 => "Eight",
              9 => "Nine",
              _ => "",
            }
          );
        }

        if (j == 0 && p[j] != 0)
        {
          words.Add("Hundred");
        }
      }
  
      if (i + 1 > 1 && p[0] + p[1] + p[2] != 0)
      {
        words.Add(
          (i + 1) switch
          {
            2 => "Thousand",
            3 => "Million",
            4 => "Billion",
            _ => "",
          }
        );
      }
    }

    return string.Join(" ", words);
  }
}