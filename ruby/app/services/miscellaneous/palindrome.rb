# Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

module Miscellaneous
  module Palindrome
    def self.first_palindrome(words)
      words.each do |w|
        if w == w.reverse
          return w
        end
      end

      ""
    end
  end
end