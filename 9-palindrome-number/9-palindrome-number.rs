impl Solution {
    pub fn is_palindrome(mut x: i32) -> bool {
        let x = x.to_string();
        let x = x.as_bytes();

        let mut l = 0;
        let mut r = x.len() - 1;

        while l < r {
            if x[l] != x[r] {
                return false;
            }
            l += 1;
            r -= 1;
        }

        true
    }
}