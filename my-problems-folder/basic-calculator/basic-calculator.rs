impl Solution {
    pub fn calculate(s: String) -> i32 {
        Self::calc(&mut s.chars())
    }

    fn calc(chars: &mut std::str::Chars) -> i32 {
        let mut ans = 0;
        let mut curr = 0;
        let mut sig = 1;
        let mut has_num = false;
        loop {
            let ch = chars.next().unwrap_or(')');
            if ch >= '0' && ch <= '9' {
                curr = curr * 10 + ch as i32  - '0' as i32;
                has_num = true;
            }
            else {
                if has_num {
                    ans += curr * sig;
                    curr = 0;
                    sig = 1;
                    has_num = false;
                }
                match ch {
                    '(' => {
                        ans += Self::calc(chars) * sig;
                        sig = 1;
                    }
                    ')' => return ans,
                    '-' => sig = -sig,
                    _ => (),
                }
            }
        }
    }
}