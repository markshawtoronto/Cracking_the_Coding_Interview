# Given an integer x, return true if x is palindrome integer.
#
# An integer is a palindrome when it reads the same backward as forward.

module Miscellaneous
  module PalindromeInteger
    # Simpler implementation
    def self.is_palindrome_simple(x)
      x.to_s.reverse == s.to_s
    end

    # Using the constraint - no converting to a string
    def self.is_palindrome(x)
      return false if x < 0

      i = 0
      while i <= x.digits.size / 2 do
        if x.digits[i] != x.digits[-i - 1]
          return false
        end

        i += 1
      end

      return true
    end
  end
end