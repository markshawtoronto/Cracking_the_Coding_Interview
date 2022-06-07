module Miscellaneous
  class PalindromeSubstring
    # Given a string s, return the longest palindromic substring in s.
    def self.longest_palindrome(s)
      head = 0
      tail = 0

      (0..s.length).each do |i|
        odd_palindrome_length = self.expand_around_center(s, i, i)
        even_palindrome_length = self.expand_around_center(s, i, i+1)
        length = [odd_palindrome_length, even_palindrome_length].max
        if tail - head < length
          head = i - (length - 1) / 2
          tail = i + length / 2
        end
      end

      s[head..tail]
    end

    def self.expand_around_center(s, left, right)
      while 0 <= left && right < s.size && s[left] == s[right]
        left -= 1
        right += 1
      end
      right - left - 1
    end
  end
end
