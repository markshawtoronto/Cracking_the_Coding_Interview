# Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

module Miscellaneous
  module SherlockAnagram
    extend self

    def solve(s)
      all_substrings = {}
      anagram_count = 0
      for i in 0..s.length-1 do
        for j in i..s.length-1 do
          s1 = s[i..j]
          all_substrings[s1.length] ||= {}
          all_substrings[s1.length][s1.chars.sort.join] ||= 0
          anagram_count += all_substrings[s1.length][s1.chars.sort.join] if all_substrings[s1.length][s1.chars.sort.join] > 0
          all_substrings[s1.length][s1.chars.sort.join] += 1
        end
      end
      anagram_count
    end

    def anagram(s1, s2)
      s1.chars.sort.join == s2.chars.sort.join
    end
  end
end
