public class Solution {
  public int EvalRPN(string[] tokens) {
    var numbers = new List<int>(4);
    int num1, num2;

    foreach (string token in tokens)
    {
        
      switch(token)
      {
        case "+":
        num1 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        num2 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        numbers.Add(num1 + num2);
        break;

        case "-":
        num2 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        num1 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        numbers.Add(num1 - num2);
        break;

        case "*":
        num1 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        num2 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        numbers.Add(num1 * num2);
        break;

        case "/":
        num2 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        num1 = numbers[^1];
        numbers.RemoveAt(numbers.Count - 1);
        numbers.Add(num1 / num2);
        break;

        default:
        numbers.Add(int.Parse(token));
        break;
      }
    }

    return numbers[^1];
  }
}