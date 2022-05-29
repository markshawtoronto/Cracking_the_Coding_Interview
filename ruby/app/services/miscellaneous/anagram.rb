# Determine how many characters are different between two strings.
# If these characters were removed, the two strings would be anagrams.

module Miscellaneous
  module Anagram
    extend self

    def make_anagram(a, b)
      # Create a histogram for characters in a
      histogram = {}
      a.chars.each do |letter|
        if histogram[letter].nil?
          histogram[letter] = 1
        else
          histogram[letter] += 1
        end
      end

      # Loop over b, subtracting characters from the histogram
      b.chars.each do |letter|
        if histogram[letter].nil?
          histogram[letter] = -1
        else
          histogram[letter] -= 1
        end
      end

      # Loop over the histogram, taking the absolute value of the remaining.
      result = 0
      histogram.each do |letter, value|
        result += value.abs
      end
      result
    end
  end
end
