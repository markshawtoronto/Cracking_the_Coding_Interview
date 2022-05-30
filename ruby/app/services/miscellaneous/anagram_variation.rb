# You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
# Return the minimum number of steps to make t an anagram of s.

module Miscellaneous
  module AnagramVariation
    extend self

    def make_anagram(s, t)
      # Create a histogram of all characters in the target s
      histogram = {}
      s.chars.each do |char|
        if histogram[char].nil?
          histogram[char] = 1
        else
          histogram[char] += 1
        end
      end

      # Count all the letters that are not in the histogram (target) - these are the ones to flip.
      count = 0
      t.chars.each do |letter|
        if histogram[letter].nil? || histogram[letter] < 1
          count += 1
        else
          histogram[letter] -= 1
        end
      end
      count
    end
  end
end
